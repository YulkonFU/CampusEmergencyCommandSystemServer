package cn.edu.cupk.admin.api;

import cn.edu.cupk.admin.dto.ClientAuthDTO;
import cn.edu.cupk.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 赵希奥
 * @date 2022/7/1 0:56
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@FeignClient(value = "cecs-admin", contextId = "oauth-client")
public interface OAuthClientFeignClient {
    @GetMapping("/oauth-clients/getOAuth2ClientById")
    public Result<ClientAuthDTO>getOAuth2ClientById(@RequestParam String clientId);
}
