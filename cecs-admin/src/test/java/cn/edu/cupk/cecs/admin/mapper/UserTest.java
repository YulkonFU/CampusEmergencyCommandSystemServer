package cn.edu.cupk.cecs.admin.mapper;

import cn.edu.cupk.cecs.admin.pojo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/28/17:51
 * @Description:
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private UserMapper userMapper;

    //查询User
    @Test
    void findUser() {

        //查询列表
        List<User> user =  userMapper.selectList(null);
        System.out.println("user:" + user);

        //根据ID查询
        User user1 = userMapper.selectById(1);
        System.out.println("user1:" + user1);

        //通过多个ID批量查询
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);

        //简单的条件查询
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "赵希奥");
        map.put("age", 0);
        List<User> users2 = userMapper.selectByMap(map);
        users2.forEach(System.out::println);
    }

    //添加User
    @Test
    void addUser(){
        User user = new User();
        user.setUsername("六神");
        user.setSex(0);
        user.setName("sixstar");
        user.setAge(18);
        user.setEmail("sixstar@136.com");
        user.setCreateTime("2022-06-02 06:35");
        user.setPhone("13465894578");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    //修改User
    @Test
    void updateUser(){
        User user = new User();
        user.setUserId(4);
        user.setAge(12);

        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    //删除User
    @Test
    void deleteUser(){
        //根据ID删除
        int result = userMapper.deleteById(5);
        System.out.println(result);

        //批量删除
//        int result2 = userMapper.deleteBatchIds(Arrays.asList(1,2,3));
//        System.out.println(result2);

        //简单的条件删除
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","fourstar");
        map.put("age",18);
        int result3 = userMapper.deleteByMap(map);
        System.out.println(result3);
    }

    /**
    * @Description: 分页查询测试
    * @Param:
    * @return:
    * @Author: rst
    * @Date: 2022/6/28
    */
    @Test
    void selectPage(){

        //创建page对象（1：当前页；3：每页显示记录数）
//        IPage<User> page = new Page<>(1,3);
//        IPage<User> page = new IPage
//        //调用分页查询方法，将分页所有数据封装到page对象里面
//        userMapper.selectPage(page,null);
//        //通过page对象获取分页数据
//        System.out.println(page.getCurrent());  //当前页
//        System.out.println(page.getRecords());  //每页数据list集合
//        System.out.println(page.getPages());    //总页数
//        System.out.println(page.getSize());     //每页显示记录数
//        System.out.println(page.getTotal());    //总记录数
//        System.out.println(page.hasNext());     //是否有下一页
//        System.out.println(page.hasPrevious()); //是否有上一页

    }
}
