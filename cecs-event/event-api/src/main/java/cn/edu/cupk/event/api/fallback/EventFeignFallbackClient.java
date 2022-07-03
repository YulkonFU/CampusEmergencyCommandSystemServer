package cn.edu.cupk.event.api.fallback;

import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.api.EventFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author 赵希奥
 * @date 2022/7/2 23:22
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Slf4j
@Component
public class EventFeignFallbackClient implements EventFeignClient {
    @Override
    public Result getEventTimes() {
        log.error("feign远程调用cecs-event服务异常后的降级方法");
        return Result.failed(HttpStatus.EXPECTATION_FAILED.value(), "服务降级");
    }
}
