package cn.edu.cupk.admin.api.fallback;

import cn.edu.cupk.admin.api.UserFeignClient;
import cn.edu.cupk.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author 赵希奥
 * @date 2022/6/29 8:04
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Component
@Slf4j
public class UserFeignFallbackClient implements UserFeignClient {

    @Override
    public Result loadUserDTOByUsername(String username) {
        log.error("feign远程调用cecs-admin服务异常后的降级方法");
        return Result.failed(HttpStatus.EXPECTATION_FAILED.value(), "服务降级");
    }
}