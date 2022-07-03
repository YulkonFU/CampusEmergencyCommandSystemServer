package cn.edu.cupk.event.controller;

import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.service.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 赵希奥
 * @date 2022/7/3 14:27
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@SpringBootTest
class EventControllerTest {

    @Resource
    private EventService eventService;

    @Test
    void getEventWeek() {
        Result eventWeek = eventService.getEventWeek();
        System.out.println(eventWeek);
    }
}