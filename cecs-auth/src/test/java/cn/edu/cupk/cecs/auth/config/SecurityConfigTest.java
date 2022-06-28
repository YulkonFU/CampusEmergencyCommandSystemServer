package cn.edu.cupk.cecs.auth.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author 赵希奥
 * @date 2022/6/27 21:56
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@SpringBootTest
class SecurityConfigTest {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    public void passwordEncrypt() {
        String password = "123456";
        System.out.println(passwordEncoder.encode(password));
    }
}