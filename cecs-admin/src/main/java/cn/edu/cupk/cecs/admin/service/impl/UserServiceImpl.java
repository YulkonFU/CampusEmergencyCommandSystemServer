package cn.edu.cupk.cecs.admin.service.impl;

import cn.edu.cupk.cecs.admin.pojo.utils.PageResult;
import cn.edu.cupk.cecs.admin.pojo.entity.User;
import cn.edu.cupk.cecs.admin.mapper.UserMapper;
import cn.edu.cupk.cecs.admin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/29/16:34
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult selectUserbyName(Integer currentPage, Integer pageSize, String str) {
        if (str == null)
            str = "";
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.like(User::getUsername , str).or().like(User::getName, str);

        Page<User> userPage = new Page<>(currentPage, pageSize);
        IPage<User> userIPage = userMapper.selectPage(userPage, userLambdaQueryWrapper);
        PageResult result = PageResult.success(userIPage);
        return  result;
    }
}
