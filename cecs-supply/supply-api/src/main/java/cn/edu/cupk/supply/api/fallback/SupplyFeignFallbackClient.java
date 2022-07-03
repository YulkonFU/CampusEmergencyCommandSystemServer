package cn.edu.cupk.supply.api.fallback;

import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.supply.api.SupplyFeignClient;
import org.springframework.http.HttpStatus;

/**
 * @author 赵希奥
 * @date 2022/7/3 19:45
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public class SupplyFeignFallbackClient implements SupplyFeignClient {
    @Override
    public Result getRemaining() {
        return Result.failed(HttpStatus.INTERNAL_SERVER_ERROR.value(), "物资数量获取失败");
    }
}
