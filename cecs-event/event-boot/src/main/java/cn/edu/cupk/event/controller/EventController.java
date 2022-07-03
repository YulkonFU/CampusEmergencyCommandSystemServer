package cn.edu.cupk.event.controller;

import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.pojo.entity.Event;
import cn.edu.cupk.event.pojo.query.EventPageQuery;
import cn.edu.cupk.event.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author 赵希奥
 * @date 2022/7/2 12:27
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Slf4j
@RestController
@RequestMapping("/events")
public class EventController {


    @Resource
    private EventService eventService;

    @GetMapping("/list")
    public PageResult listEventPages(EventPageQuery queryParams) {
        return eventService.listEventPages(queryParams);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Result getEventById(@PathVariable("id") Long id) {
        if (id <= 0) {
            return Result.failed(HttpStatus.BAD_REQUEST.value(), "参数错误");
        }
        return Result.success(eventService.getById(id));
    }

    @PostMapping("")
    @ResponseBody
    public Result addEvent(@RequestBody Event event) {
        if (event == null) {
            return Result.failed(HttpStatus.BAD_REQUEST.value(), "参数错误");
        }
        return Result.success(eventService.save(event));
    }

    @PutMapping("/terminate")
    @ResponseBody
    public Result terminateEvent(@RequestParam("id") Long id, @RequestParam("status") Integer status,
                                 @RequestParam("reason") String reason) {
        if (id <= 0 || (status != 3 && status != 4)) {
            return Result.failed(HttpStatus.BAD_REQUEST.value(), "参数错误");
        }
        Event event = eventService.getById(id);
        log.info("event from DB: {}", event);
        if (event == null) {
            return Result.failed(HttpStatus.BAD_REQUEST.value(), "无此事件");
        }

        // event.setStatus(EventStatusEnum.getByValue(status));
        // event.setStatus(status)
        event.setDescription(event.getDescription() + "，终止原因：" + reason);
        event.setEndTime(LocalDateTime.now());
        log.info("event after process: {}", event);
        return Result.success("终止成功", eventService.updateById(event));
    }

    @GetMapping("/times")
    @ResponseBody
    public Result getEventTimes() {
        return eventService.getEventTimes();
    }

    @GetMapping("/periods")
    @ResponseBody
    public Result getEventPeriods() {
        // todo 将每段时间空的需要填0返回
        return eventService.getEventPeriod();
    }

    @GetMapping("/week")
    @ResponseBody
    public Result getEventWeek() {
        return eventService.getEventWeek();
    }
}
