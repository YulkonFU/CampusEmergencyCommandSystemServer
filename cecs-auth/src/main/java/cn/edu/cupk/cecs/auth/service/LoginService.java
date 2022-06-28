package cn.edu.cupk.cecs.auth.service;

import cn.edu.cupk.cecs.auth.domain.ResponseResult;
import cn.edu.cupk.cecs.auth.entity.UserInfo;

/**
 * @author 赵希奥
 * @date 2022/6/27 20:26
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public interface LoginService {

    ResponseResult login(UserInfo userInfo);

    ResponseResult logout();
}
