package cn.edu.cupk.event.service.impl;

import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.service.EventService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 赵希奥
 * @date 2022/7/3 0:41
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@SpringBootTest
class EventServiceImplTest {

    @Resource
    private EventService eventService;

    @Test
    void getEventTimes() {
        Result eventTimes = eventService.getEventTimes();
        System.out.println(eventTimes);
    }

}