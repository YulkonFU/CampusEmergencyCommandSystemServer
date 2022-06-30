package cn.edu.cupk.admin.controller;

import cn.edu.cupk.admin.dto.ClientAuthDTO;
import cn.edu.cupk.admin.entity.OauthClient;
import cn.edu.cupk.admin.service.OAuthClientService;
import cn.edu.cupk.common.result.Result;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵希奥
 * @date 2022/7/1 1:04
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@RestController
@RequestMapping("/oauth-clients")
@RequiredArgsConstructor
public class OAuthClientCotroller {

    private final OAuthClientService clientService;

    @GetMapping("/getOAuth2ClientById")
    public Result<ClientAuthDTO> getOAuth2ClientById( @RequestParam String clientId) {
        OauthClient client = clientService.getById(clientId);
        Assert.isTrue(client != null, "OAuth2 客户端不存在");
        ClientAuthDTO clientAuthDTO = new ClientAuthDTO();
        BeanUtil.copyProperties(client, clientAuthDTO);
        return Result.success(clientAuthDTO);
    }

}
