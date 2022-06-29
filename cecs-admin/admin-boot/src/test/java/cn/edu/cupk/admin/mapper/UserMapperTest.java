package cn.edu.cupk.admin.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 赵希奥
 * @date 2022/6/29 15:32
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@SpringBootApplication
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void getAuthInfoByUsername() {
        System.out.println(userMapper.getAuthInfoByUsername("admin"));
    }


}