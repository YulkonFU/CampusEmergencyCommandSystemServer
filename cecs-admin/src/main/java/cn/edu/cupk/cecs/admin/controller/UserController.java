package cn.edu.cupk.cecs.admin.controller;

import cn.edu.cupk.cecs.admin.pojo.form.UserForm;
import cn.edu.cupk.cecs.admin.pojo.form.UserRoleForm;
import cn.edu.cupk.cecs.admin.pojo.utils.PageResult;
import cn.edu.cupk.cecs.admin.pojo.utils.Result;
import cn.edu.cupk.cecs.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/29/15:30
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ResponseBody
    @GetMapping("/users")
    public PageResult selectUsers(@RequestParam(defaultValue = "1",value = "pageNum") Integer currentPage,
                                  @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize,
                                  @RequestParam(defaultValue = "",value = "name") String name)
    {
        return userService.findUserList(currentPage, pageSize, name);
    }
    @ResponseBody
    @PostMapping("/newUser")
    public Result<UserRoleForm> addNewUser(UserRoleForm userRoleForm){
        return userService.addNewUser(userRoleForm);
    }

    @ResponseBody
    @DeleteMapping("/user")
    public Result<UserForm> deletedUser(@RequestParam(value = "id") Integer userId){
        return userService.deleteUserByID(userId);
    }

    @ResponseBody
    @PutMapping("/user")
    public Result<UserRoleForm> updateUser(UserRoleForm userRoleForm){
        return userService.updateUser(userRoleForm);
    }

    @ResponseBody
    @GetMapping("/userDetail")
    public Result<UserRoleForm> findUserDetail(long id){
        return userService.findUserDetail(id);
    }
}
