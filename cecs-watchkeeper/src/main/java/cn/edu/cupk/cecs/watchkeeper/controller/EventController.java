package cn.edu.cupk.cecs.watchkeeper.controller;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.Event;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventList;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/18:18
 * @Description:
 */
@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @ResponseBody
    @PostMapping("/newEvent")
    public Result<Event> reportEvent(EventForm eventForm){
        return eventService.reportIncident(eventForm);
    }

    @ResponseBody
    @GetMapping("/list")
    public Result<EventList> searchEvents(long userId){
        return eventService.searchEvents(userId);
    }
}
