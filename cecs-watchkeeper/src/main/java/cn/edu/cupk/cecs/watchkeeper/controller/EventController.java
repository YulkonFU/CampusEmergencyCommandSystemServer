package cn.edu.cupk.cecs.watchkeeper.controller;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.Event;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventList;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventPlanForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventPlanList;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/18:18
 * @Description:
 */
@Controller
@RequestMapping("/weixin/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @ResponseBody
    @PostMapping("/newEvent")
    public Result<Event> reportEvent(@RequestBody EventForm eventForm){
        return eventService.reportIncident(eventForm);
    }

    @ResponseBody
    @GetMapping("/list")
    public Result<EventList> searchEvents(long userId){
        return eventService.searchEvents(userId);
    }

    @ResponseBody
    @GetMapping("/")
    public Result<EventPlanList> findEvents(){
        return eventService.findEvents();
    }

    @ResponseBody
    @PatchMapping("/escalation")
    public Result escalation(long eventId,Integer status){
        Boolean flag = eventService.escalation(eventId,status);
        if(flag == true){
            return Result.success("已提交！");
        }
        else return Result.failed(403,"响应失败");
    }
}
