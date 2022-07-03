package cn.edu.cupk.event.api;

import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.api.fallback.EventFeignFallbackClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 赵希奥
 * @date 2022/7/2 23:09
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Component
@FeignClient(value = "cecs-event", fallback = EventFeignFallbackClient.class)
public interface EventFeignClient {

     @GetMapping("/events/times")
     public Result getEventTimes();


}
