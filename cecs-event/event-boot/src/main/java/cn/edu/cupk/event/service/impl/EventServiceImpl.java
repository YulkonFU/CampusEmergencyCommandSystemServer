package cn.edu.cupk.event.service.impl;

import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.mapper.EventMapper;
import cn.edu.cupk.event.pojo.entity.Event;
import cn.edu.cupk.event.pojo.entity.enums.EventTypeEnum;
import cn.edu.cupk.event.pojo.query.EventPageQuery;
import cn.edu.cupk.event.pojo.vo.EventTimesVO;
import cn.edu.cupk.event.service.EventService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public PageResult listEventPages(EventPageQuery queryParams) {
        IPage<Event> page = new Page<>(queryParams.getPageNum(), queryParams.getPageSize());
        LambdaQueryWrapper<Event> wrapper = new LambdaQueryWrapper<Event>();
        wrapper.eq(Event::getDeleted, 0)
                .like(StringUtils.hasText(queryParams.getKeywords()),Event::getEventId, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getPlanId, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getReporter, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getType, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getDescription, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getLocation, queryParams.getKeywords())
                .or().like(StringUtils.hasText(queryParams.getKeywords()),Event::getStatus, queryParams.getKeywords())
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
}
