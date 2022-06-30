package cn.edu.cupk.cecs.admin.service;

import cn.edu.cupk.cecs.admin.pojo.entity.User;
import cn.edu.cupk.cecs.admin.pojo.entity.UserRole;
import cn.edu.cupk.cecs.admin.pojo.form.UserForm;
import cn.edu.cupk.cecs.admin.pojo.form.UserRoleForm;
import cn.edu.cupk.cecs.admin.pojo.utils.PageResult;
import cn.edu.cupk.cecs.admin.pojo.utils.Result;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/29/16:12
 * @Description:
 */
public interface UserService {

    PageResult findUserList(Integer currentPage, Integer pageSize, String str, Integer status);

    Result<UserRoleForm> addNewUser(UserRoleForm user);

    Result<UserForm> deleteUserByID(Integer id);

    Result<UserRoleForm> updateUser(UserRoleForm userRoleForm);

    Result<UserRoleForm> findUserDetail(long id);
}
