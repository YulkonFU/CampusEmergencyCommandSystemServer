package cn.edu.cupk.cecs.watchkeeper.service.impl;

import cn.edu.cupk.cecs.watchkeeper.mapper.EventMapper;
import cn.edu.cupk.cecs.watchkeeper.mapper.UserMapper;
import cn.edu.cupk.cecs.watchkeeper.pojo.entity.Event;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.*;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.EventService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/17:44
 * @Description:
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result<Event> reportIncident(EventForm eventForm) {
        String name = userMapper.searchName(eventForm.getReporter());
        String description = "事件发生时间："+eventForm.getStartTime()+"\n"
                +"事件上报人："+name+"\n"
                +"事件描述："+eventForm.getDescription()+"\n";
        eventForm.setDescription(description);
        eventForm.setStatus(0);
        int flag = eventMapper.insert(eventForm);
        if(flag == 1){
            LambdaQueryWrapper<Event> eventLambdaQueryWrapper = new LambdaQueryWrapper<>();
            eventLambdaQueryWrapper.eq(Event::getReporter,eventForm.getReporter())
                    .eq(Event::getStartTime,eventForm.getStartTime())
                    .eq(Event::getLocation,eventForm.getLocation());
            Event event = eventMapper.selectOne(eventLambdaQueryWrapper);
            return Result.success("成功",event);
        }
        return Result.failed(403,"失败");
    }

    @Override
    public Result<EventList> searchEvents(long userId) {
        List<EventArray> eventArrays = eventMapper.searchEventList(userId);
        Integer num = eventArrays.size();
        EventList eventList = new EventList();
        eventList.setTotal(num);
        eventList.setList(eventArrays);
        Result<EventList> result = Result.success(eventList);
        return result;
    }

    @Override
    public Result<EventPlanList> findEvents() {
        List<EventPlanForm> eventPlanForms = eventMapper.findEventsAndPlan();
        Integer num = eventPlanForms.size();
        EventPlanList eventPlanList = new EventPlanList();
        eventPlanList.setTotal(num);
        eventPlanList.setList(eventPlanForms);
        Result<EventPlanList> result = Result.success(eventPlanList);
        return result;
    }

    @Override
    public Boolean escalation(long eventId, Integer status) {
        if(status > 0) status = 2;
        else {
            return false;
        }
        int flag = eventMapper.escalation(eventId,status);
        if(flag == 1){
            return true;
        }
        return false;
    }
}
