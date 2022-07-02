package cn.edu.cupk.cecs.admin.controller;

import cn.edu.cupk.cecs.admin.pojo.entity.User;
import cn.edu.cupk.cecs.admin.mapper.UserMapper;
import cn.edu.cupk.cecs.admin.pojo.form.UserForm;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/29/11:43
 * @Description:
 */
@SpringBootTest
public class UserMapperPageTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectPage(){
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.like(User::getUsername , "");

        Page<User> userPage = new Page<>(1 , 5);
        IPage<User> userIPage = userMapper.selectPage(userPage, userLambdaQueryWrapper);
        System.out.println("总页数： "+userIPage.getPages());
        System.out.println("总记录数： "+userIPage.getTotal());
        userIPage.getRecords().forEach(System.out::println);

    }



//    @Test
//    public void findUserList(){
//        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        userLambdaQueryWrapper
//                .eq(User::getStatus,0)
//                .apply("user.id = user_role.user_id")
//                .apply("role.id = user_role.role_id")
//                .like(User::getName , "");
//
//        Page<UserForm> userPage = new Page<>(1 , 5);
//        IPage<UserForm> userIPage = userMapper.findUser(userPage, userLambdaQueryWrapper);
//        System.out.println("总页数： "+userIPage.getPages());
//        System.out.println("总记录数： "+userIPage.getTotal());
//        userIPage.getRecords().forEach(System.out::println);
//    }

//    @Test
//    public void addUser(){
//        User newUser = new User(
//                "2019015214","123456","rst",0,21,"15531454@qq.com","123456789"
//        );
//        Date date = new Date();
//        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
//        String dateTime = ft.format(date);
//        newUser.setCreateTime(dateTime);
//        int insertResult = userMapper.insert(newUser);
//        System.out.println(insertResult);
//    }

}
