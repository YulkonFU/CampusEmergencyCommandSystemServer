package cn.edu.cupk.event.service.impl;

import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.mapper.*;
import cn.edu.cupk.event.pojo.entity.Event;
import cn.edu.cupk.event.pojo.entity.HumanResource;
import cn.edu.cupk.event.pojo.entity.Source;
import cn.edu.cupk.event.pojo.entity.enums.EventTypeEnum;
import cn.edu.cupk.event.pojo.query.EventPageQuery;
import cn.edu.cupk.event.pojo.vo.EventTimesVO;
import cn.edu.cupk.event.service.EventService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 赵希奥
 * @date 2022/7/2 16:30
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements EventService {

    @Resource
    private EventMapper eventMapper;

    @Autowired
    ProcessMapper processMapper;
    @Autowired
    ProcessHumanResourceMapper process_humanResourceMapper;
    @Autowired
    ProcessSupplyMapper process_supplyMapper;
    @Autowired
    HumanResourceMapper humanResourceMapper;
    @Autowired
    SupplyMapper supplyMapper;

    @Override
    public PageResult listEventPages(EventPageQuery queryParams) {
        IPage<Event> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<Event> wrapper = new LambdaQueryWrapper<Event>();
        wrapper.eq(queryParams.getStatus() != null, Event::getStatus, queryParams.getStatus())
                .like(StringUtils.hasText(queryParams.getKeywords()),Event::getEventId, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getPlanId, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getReporter, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getType, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getDescription, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getLocation, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getCommander, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getLevel, queryParams.getKeywords());

        IPage<Event> eventIPage = eventMapper.selectPage(page, wrapper);
        return PageResult.success(eventIPage);
    }

    @Override
    public Result getEventTimes() {
        List<EventTimesVO> eventTimesVOS = new ArrayList<>();
        List<Map<String, Object>> eventTimes = eventMapper.getEventTimes();
        for (Map<String, Object> eventTime : eventTimes) {
            EventTimesVO eventTimesVO = new EventTimesVO();
            eventTimesVO.setName(EventTypeEnum.getDescByValue((Integer) eventTime.get("type")));
            eventTimesVO.setValue((Long) eventTime.get("count"));
            eventTimesVOS.add(eventTimesVO);
        }
        return Result.success("查询成功", eventTimesVOS);
    }

    @Override
    public Result getEventPeriod() {
        return Result.success("查询成功", eventMapper.getEventPeriod());
    }

    @Override
    public Result getEventWeek() {
        // TODO 一周事件情况
        return Result.success("查询成功", eventMapper.getWeekEvent());
    }

    @Override
    public Boolean handlingEvent(long eventId, List<Source> humanResource, List<Source> goodsResource) {
        //首先向进程中添加一条事件进程数据（需要判断是否是事态升级还是第一次添加）
        //1.首先查询数据库中有多少条与该事件有关的流程
        Boolean flag;
        Integer processId, newNode;
        Integer num=processMapper.acquireNumOfEvent(eventId);//若为0，说明为第一次处理该事件
//        Boolean a= processMapper.insertNewOne(eventId);
        if(num > 0){
            processId = processMapper.findEndNode(eventId);
            processMapper.updateStatus(processId);
            flag = processMapper.insertOne(eventId);
            newNode = processMapper.findEndNode(eventId);
            processMapper.fillNextNode(processId,newNode);

        }
        else flag = processMapper.insertNewOne(eventId);


        //添加成功获取添加的进程id(此时其后置节点应该为空则为链尾)

        processId = processMapper.findEndNode(eventId);
        //获取processId后，就可以往进程_人员和进程_物资表中插入数据了
        //2.进程_人员表添加
        if(humanResource.size()!=0){
            for (int i=0;i<humanResource.size();i++){
                //减少人员表中的数据需要判断距离，首先获取数据库同类型的数据并根据距离排序
                //首先获取该类人员的列表(先判断type)
                Integer type=null;//保存当前数据是什么类型
                switch (humanResource.get(i).getName()){
                    case "消防人员":type=1;break;
                    case "警务人员":type=2;break;
                    case "医务人员":type=0;break;
                }
                List<HumanResource> humanList=humanResourceMapper.getListByType(type);
                Integer number= Integer.valueOf(humanResource.get(i).getNumber());//获取当前需要的数量
                List<HumanResource> selectList= new ArrayList<HumanResource>();
                for (int j=0;i<humanList.size();j++){
                    //如果当前组织所有人数小于所需，则将当前组织全部给选择
                    if(humanList.get(j).getNumber()<number){
                        selectList.add(humanList.get(j));
                        number-=humanList.get(j).getNumber();
                    }else {
                        //如果大于等于所需，则选择当前组织的一部分人参与部署
                        humanList.get(j).setNumber(number);
                        selectList.add(humanList.get(j));
                        break;
                    }
                }
                //将刚刚选择的人员传入人员表中进行修改
                Boolean b=humanResourceMapper.getResource(selectList);
                //修改成功后将记录存在进程_人员表中
                Boolean c =process_humanResourceMapper.insertList(selectList,processId);
            }
        }
        if(goodsResource.size()!=0){
            for (int i=0;i<goodsResource.size();i++){
                String name = goodsResource.get(i).getName();
                Integer number = Integer.valueOf(goodsResource.get(i).getNumber());
                supplyMapper.updateSupply(name,number);
                long supplyId = supplyMapper.findSupplyID(name);
                process_supplyMapper.insertNewOne(supplyId,processId,number);
//                Boolean d =process_supplyMapper.insert(eventId,processId);  //应为(supplyID,processId)
//                if(d){
//                    Boolean e=supplyMapper.getSupply(goodsResource);
//                }
            }
        }
        return flag;
    }
}
