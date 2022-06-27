package cn.edu.cupk.cecs.auth.service.impl;

import cn.edu.cupk.cecs.auth.domain.LoginUser;
import cn.edu.cupk.cecs.auth.entity.UserInfo;
import cn.edu.cupk.cecs.auth.mapper.PermissionMapper;
import cn.edu.cupk.cecs.auth.mapper.UserInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author 赵希奥
 * @date 2022/6/27 10:55
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // 查询用户信息
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUsername, username);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        if (Objects.isNull(userInfo)) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 定义权限列表
        List<String> permissionKeyList =  permissionMapper.selectPermsByUserId(userInfo.getId());
        return new LoginUser(userInfo,permissionKeyList);
    }
}

