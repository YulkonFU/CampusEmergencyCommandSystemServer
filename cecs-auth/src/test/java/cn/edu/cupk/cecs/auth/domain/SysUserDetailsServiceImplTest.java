package cn.edu.cupk.cecs.auth.domain;

import cn.edu.cupk.cecs.auth.service.impl.SysUserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;

/**
 * @author 赵希奥
 * @date 2022/6/27 18:50
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@SpringBootTest
class SysUserDetailsServiceImplTest {

    @Resource
    private SysUserDetailsServiceImpl sysUserDetailsService;

    @Test
    public void test() {
        UserDetails userInfo =sysUserDetailsService.loadUserByUsername("admin");
        System.out.println(userInfo);
    }
}