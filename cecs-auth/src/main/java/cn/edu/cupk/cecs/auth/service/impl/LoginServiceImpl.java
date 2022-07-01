package cn.edu.cupk.cecs.auth.service.impl;

import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.cecs.auth.service.LoginService;
import cn.edu.cupk.cecs.auth.userdetails.LoginUser;
import cn.edu.cupk.common.redis.util.RedisCache;
import cn.edu.cupk.common.result.Result;

import cn.edu.cupk.common.web.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author 赵希奥
 * @date 2022/6/27 20:32
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;

    @Override
    public Result login(UserAuthDTO userInfo) {
        // AuthenticationManager authenticate 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userInfo.getUsername(), userInfo.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 如果认证未通过, 给出对应提示
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        // 使用userId生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUserInfo().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        // authenticate存入redis
        redisCache.setCacheObject("login:" + userId, loginUser);
        // 把token响应给前端
        HashMap<String, Object> map = new HashMap<>();
        // TODO 是否要返回姓名?
        map.put("id", Integer.parseInt(userId));
        map.put("username", loginUser.getUserInfo().getUsername());
        map.put("role", loginUser.getUserInfo().getRoles());
        map.put("token", jwt);
        return Result.success("登录成功", map);
    }

    @Override
    public Result logout() {
        // 获取SecurityContextHolder中的用户id
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserAuthDTO userInfo = (UserAuthDTO) authentication.getPrincipal();
        Long userId = userInfo.getId();
        // 删除redis中的值
        redisCache.deleteObject("login:" + userId);
        return Result.success("注销成功");
    }
}
