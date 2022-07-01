package cn.edu.cupk.cecs.auth.service.impl;

import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.common.web.utils.WebUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 赵希奥
 * @date 2022/6/27 23:07
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        Result result = Result.failed(HttpStatus.UNAUTHORIZED.value(), "账号或密码错误");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}
