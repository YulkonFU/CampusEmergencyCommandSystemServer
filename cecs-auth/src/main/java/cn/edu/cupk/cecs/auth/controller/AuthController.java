package cn.edu.cupk.cecs.auth.controller;

import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.cecs.auth.service.LoginService;
import cn.edu.cupk.common.result.Result;
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
@RequestMapping
public class AuthController {

    @Resource
    private LoginService loginService;

    @PostMapping("/user/login")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserAuthDTO userInfo = new UserAuthDTO();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        return loginService.login(userInfo);
    }

    @GetMapping("/user/logout")
    public Result logout() {
        return loginService.logout();
    }

}
