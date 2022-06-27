package cn.edu.cupk.cecs.auth.mapper;

import cn.edu.cupk.cecs.auth.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 赵希奥
 * @date 2022/6/27 17:29
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@SpringBootTest
class UserInfoMapperTest {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Test
    public void test() {
        UserInfo userInfo = new UserInfo();
        userInfo = userInfoMapper.selectById(1L);
        System.out.println(userInfo);
    }
}