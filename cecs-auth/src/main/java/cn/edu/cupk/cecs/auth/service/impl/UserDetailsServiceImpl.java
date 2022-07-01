package cn.edu.cupk.cecs.auth.service.impl;

import cn.edu.cupk.admin.api.UserFeignClient;
import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.cecs.auth.userdetails.LoginUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author 赵希奥
 * @date 2022/6/27 10:55
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Service("userDetailsService")
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserFeignClient userFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // 查询用户信息
        UserAuthDTO userInfo = userFeignClient.loadUserDTOByUsername(username).getData();

        if (Objects.isNull(userInfo)) {
            throw new UsernameNotFoundException("用户不存在");
        }

        return new LoginUser(userInfo);
    }
}

