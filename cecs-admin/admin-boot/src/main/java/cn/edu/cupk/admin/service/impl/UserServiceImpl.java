package cn.edu.cupk.admin.service.impl;

import cn.edu.cupk.admin.pojo.entity.User;
import cn.edu.cupk.admin.mapper.UserMapper;
import cn.edu.cupk.admin.service.UserService;
import cn.edu.cupk.admin.dto.UserAuthDTO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 赵希奥
 * @date 2022/6/29 11:38
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public UserAuthDTO getAuthInfoByUsername(String username) {
        return this.baseMapper.getAuthInfoByUsername(username);
    }
}
