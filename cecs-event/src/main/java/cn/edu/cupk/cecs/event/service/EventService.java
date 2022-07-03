package cn.edu.cupk.cecs.event.service;

import cn.edu.cupk.cecs.event.mapper.*;
import cn.edu.cupk.cecs.event.pojo.entity.HumanResource;
import cn.edu.cupk.cecs.event.pojo.entity.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    @Autowired
    ProcessMapper processMapper;
    @Autowired
    Process_HumanResourceMapper process_humanResourceMapper;
    @Autowired
    ProcessSupplyMapper process_supplyMapper;
    @Autowired
    HumanResourceMapper humanResourceMapper;
    @Autowired
    SupplyMapper supplyMapper;
    //部署事件
    public Boolean deploy(long eventId, List<Source> humanResource, List<Source> goodsResource) {
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
