package cn.edu.cupk.admin.api;

import cn.edu.cupk.admin.api.fallback.UserFeignFallbackClient;
import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 赵希奥
 * @date 2022/6/29 6:56
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Component
@FeignClient(value = "cecs-admin", fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    @GetMapping("/users/username/{username}")
    Result<UserAuthDTO> loadUserDTOByUsername(@PathVariable String username);
}
