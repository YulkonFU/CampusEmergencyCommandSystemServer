package cn.edu.cupk.cecs.auth.security.core.clientdetails;

import cn.edu.cupk.cecs.auth.enums.PasswordEncoderTypeEnum;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * @author 赵希奥
 * @date 2022/6/29 5:39
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public class ClientDetailsServiceImpl implements ClientDetailsService {
    private final OAuthClientFeignClient clientFeignClient;

    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        try {
            Result<ClientAuthDTO> result = oAuthClientFeignClient.getOAuth2ClientById(clientId);
            if (Result.success().getCode().equals(result.getCode())) {
                ClientAuthDTO client = result.getData();
                BaseClientDetails clientDetails = new BaseClientDetails(
                        client.getClientId(),
                        client.getResourceIds(),
                        client.getScope(),
                        client.getAuthorizedGrantTypes(),
                        client.getAuthorities(),
                        client.getWebServerRedirectUri()
                );
                clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + client.getClientSecret());
                clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity());
                clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValidity());
                return clientDetails;
            } else {
                throw new NoSuchClientException("No client with requested id: " + clientId);
            }
        } catch (EmptyResultDataAccessException var4) {
            throw new NoSuchClientException("No client with requested id: " + clientId);
        }
    }
}
