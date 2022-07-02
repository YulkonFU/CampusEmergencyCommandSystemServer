package cn.edu.cupk.admin.service;

import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.admin.pojo.entity.User;
import cn.edu.cupk.admin.pojo.form.UserForm;
import cn.edu.cupk.admin.pojo.form.UserRoleForm;
import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 赵希奥
 * @date 2022/6/29 11:37
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public interface UserService extends IService<User> {

    PageResult findUserList(Integer currentPage, Integer pageSize, String str, Integer status);

    Result<UserRoleForm> addNewUser(UserRoleForm user);

    Result<UserForm> deleteUserByID(Integer id);

    int countByUsername(String username);

    Result<UserRoleForm> updateUser(UserRoleForm userRoleForm);

    Result<UserRoleForm> findUserDetail(long id);

    UserAuthDTO getAuthInfoByUsername(String username);


}
