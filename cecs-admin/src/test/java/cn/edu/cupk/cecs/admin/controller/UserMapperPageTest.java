package cn.edu.cupk.cecs.admin.controller;

import cn.edu.cupk.cecs.admin.pojo.entity.User;
import cn.edu.cupk.cecs.admin.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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


}
