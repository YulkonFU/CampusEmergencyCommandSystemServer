package cn.edu.cupk.cecs.auth.security.config;

import cn.edu.cupk.cecs.auth.service.impl.SysUserDetailsServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

/**
 * @author 赵希奥
 * @date 2022/6/29 5:29
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private AuthenticationManager authenticationManager;
    private SysUserDetailsServiceImpl sysUserDetailsService;
}

