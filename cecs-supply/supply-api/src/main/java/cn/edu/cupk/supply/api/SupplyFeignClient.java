package cn.edu.cupk.supply.api;

import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.supply.api.fallback.SupplyFeignFallbackClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 赵希奥
 * @date 2022/7/3 19:12
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Component
@FeignClient(value = "cecs-supply", contextId = "panel2supply", fallback = SupplyFeignFallbackClient.class)
public interface SupplyFeignClient {
    @GetMapping("/supply/remaining")
    Result getRemaining();
}
