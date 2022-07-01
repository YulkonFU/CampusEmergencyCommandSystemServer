package cn.edu.cupk.admin.service;

import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.admin.pojo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 赵希奥
 * @date 2022/6/29 11:37
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public interface UserService extends IService<User> {
    UserAuthDTO getAuthInfoByUsername(String username);
}
