package cn.edu.cupk.event.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * @author 赵希奥
 * @date 2022/7/2 23:54
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@SpringBootTest
class EventMapperTest {

    @Resource
    private EventMapper eventMapper;

    @Test
    void getEventTimes() {
        List<Map<String, Object>> eventTimes = eventMapper.getEventTimes();
        System.out.println(eventTimes);
    }

    @Test
    void getEventPeriod() {
        List<Map<String, Integer>> eventPeriod = eventMapper.getEventPeriod();
        System.out.println(eventPeriod);
    }
}