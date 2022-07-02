package cn.edu.cupk.cecs.watchkeeper.service.impl;

import cn.edu.cupk.cecs.watchkeeper.mapper.UserMapper;
import cn.edu.cupk.cecs.watchkeeper.pojo.entity.User;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/15:48
 * @Description:
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    /**
    * @Description: 用户获取自己的个人信息
    * @Param: [username]
    * @return: cn.edu.cupk.cecs.watchkeeper.pojo.entity.User
    * @Author: rst
    * @Date: 2022/7/1
    */
    @Override
    public Result<User> getPersonalInformation(String username) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(userLambdaQueryWrapper);

        Result<User> result = Result.success(user);
        return result;
    }

    @Override
    public Result<User> changePassword(String password,String username) {
        int flag = userMapper.updatePassword(password,username);
        if(flag == 1){
            return Result.success("成功");
        }
        return Result.failed(403,"失败");
    }
}
