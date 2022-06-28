package cn.edu.cupk.cecs.auth.controller;

import cn.edu.cupk.cecs.auth.domain.ResponseResult;
import cn.edu.cupk.cecs.auth.entity.UserInfo;
import cn.edu.cupk.cecs.auth.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 赵希奥
 * @date 2022/6/27 20:24
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        return loginService.login(userInfo);
    }

    @GetMapping("/user/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }

}
