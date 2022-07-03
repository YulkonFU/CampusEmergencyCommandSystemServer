package cn.edu.cupk.event.api;

import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.api.fallback.EventFeignFallbackClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 赵希奥
 * @date 2022/7/2 23:09
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Component
@FeignClient(value = "cecs-event", contextId = "panel2event", fallback = EventFeignFallbackClient.class)
public interface EventFeignClient {

     @GetMapping("/events/times")
     Result getEventTimes();

     @GetMapping("/events/periods")
     Result getEventPeriod();


     @GetMapping("/events/week")
     Result getEventWeek();
}
