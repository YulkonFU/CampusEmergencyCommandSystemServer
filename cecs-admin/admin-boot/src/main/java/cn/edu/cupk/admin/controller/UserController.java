package cn.edu.cupk.admin.controller;

import cn.edu.cupk.admin.pojo.form.UserForm;
import cn.edu.cupk.admin.pojo.form.UserRoleForm;
import cn.edu.cupk.admin.service.UserService;
import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 赵希奥
 * @date 2022/6/29 11:31
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;

    @ResponseBody
    @GetMapping("/list")
    public PageResult selectUsers(@RequestParam(defaultValue = "1",value = "pageNum") Integer currentPage,
                                  @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize,
                                  @RequestParam(defaultValue = "",value = "str", required = false) String str,
                                  @RequestParam(defaultValue = "0",value = "status", required = false) Integer status)
    {
        return userService.findUserList(currentPage, pageSize, str, status);
    }
    @ResponseBody
    @PostMapping("")
    public Result addNewUser(@RequestBody UserRoleForm userRoleForm){
        if (userService.countByUsername(userRoleForm.getUsername()) > 0) {
            return Result.failed(HttpStatus.BAD_REQUEST.value(), "用户名已存在");
        }
        return userService.addNewUser(userRoleForm);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Result<UserForm> deletedUser(@PathVariable("id") Integer userId){
        return userService.deleteUserByID(userId);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public Result<UserRoleForm> updateUser(@RequestBody UserRoleForm userRoleForm){
        return userService.updateUser(userRoleForm);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Result<UserRoleForm> findUserDetail(@PathVariable("id") long id){
        return userService.findUserDetail(id);
    }

    @GetMapping("/username/{username}")
    @ResponseBody
    public Result<UserAuthDTO> getAuthInfoByUsername(@PathVariable String username) {
        UserAuthDTO user = userService.getAuthInfoByUsername(username);
        return Result.success(user);
    }

}
