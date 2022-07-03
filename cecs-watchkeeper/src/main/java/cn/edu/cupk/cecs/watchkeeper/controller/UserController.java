package cn.edu.cupk.cecs.watchkeeper.controller;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.User;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/16:10
 * @Description:
 */
@Controller
@RequestMapping("/weixin/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/personalInformation")
    @ResponseBody
    public Result<User> getUserByUsername(long userId){
        return userService.getPersonalInformation(userId);
    }

    @PatchMapping("/passwordModification")
    @ResponseBody
    public Result<User> chagePassword(String username,String password){
        return userService.changePassword(password,username);
    }
}
