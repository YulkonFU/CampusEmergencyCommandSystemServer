package cn.edu.cupk.cecs.auth.service;

import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.common.result.Result;

/**
 * @author 赵希奥
 * @date 2022/6/27 20:26
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public interface LoginService {

    Result login(UserAuthDTO userInfo);

    Result logout();
}
