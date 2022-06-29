package cn.edu.cupk.cecs.admin.controller;

import cn.edu.cupk.cecs.admin.pojo.utils.PageResult;
import cn.edu.cupk.cecs.admin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
                                  @RequestParam(defaultValue = "",value = "str") String str)
    {
        return userService.selectUserbyName(currentPage,pageSize,str);
    }

}
