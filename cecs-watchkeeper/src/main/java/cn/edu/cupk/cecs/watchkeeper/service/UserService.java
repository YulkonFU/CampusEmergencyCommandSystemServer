package cn.edu.cupk.cecs.watchkeeper.service;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.User;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/15:41
 * @Description:
 */
public interface UserService {

    Result<User> getPersonalInformation(String username);

    Result<User> changePassword(String password,String username);
}
