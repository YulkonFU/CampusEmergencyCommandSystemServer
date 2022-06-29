package cn.edu.cupk.admin.controller;

import cn.edu.cupk.admin.service.UserService;
import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.common.result.Result;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 赵希奥
 * @date 2022/6/29 11:31
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@RestController
@RequestMapping("/users/")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/username/{username}")
    public Result<UserAuthDTO> getAuthInfoByUsername(@PathVariable String username) {
        UserAuthDTO user = userService.getAuthInfoByUsername(username);
        return Result.success(user);
    }

}
