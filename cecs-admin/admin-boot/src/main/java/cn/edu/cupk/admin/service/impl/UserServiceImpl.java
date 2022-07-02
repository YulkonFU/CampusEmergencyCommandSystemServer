package cn.edu.cupk.admin.service.impl;

import cn.edu.cupk.admin.mapper.RoleMapper;
import cn.edu.cupk.admin.mapper.UserRoleMapper;
import cn.edu.cupk.admin.pojo.entity.Role;
import cn.edu.cupk.admin.pojo.entity.User;
import cn.edu.cupk.admin.mapper.UserMapper;
import cn.edu.cupk.admin.pojo.entity.UserRole;
import cn.edu.cupk.admin.pojo.enums.RoleEnum;
import cn.edu.cupk.admin.pojo.form.UserForm;
import cn.edu.cupk.admin.pojo.form.UserRoleForm;
import cn.edu.cupk.admin.service.UserService;
import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 赵希奥
 * @date 2022/6/29 11:38
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageResult findUserList(Integer currentPage, Integer pageSize, String str, Integer status) {
        if (str == null)
            str = "";
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper
                .eq(User::getStatus,status)
                .apply("user.id = user_role.user_id")
                .apply("role.id = user_role.role_id")
                .like(User::getName, str);

        Page<UserForm> userPage = new Page<>(currentPage, pageSize);
        IPage<UserForm> userIPage = userMapper.findUser(userPage, userLambdaQueryWrapper);
        PageResult result = PageResult.success("查询成功", userIPage);
        return  result;

    }

    @Override
    public Result<UserRoleForm> addNewUser(UserRoleForm user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        newUser.setName(user.getName());
        newUser.setAge(user.getAge());
        newUser.setSex(user.getSex());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhoneNumber());
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String dateTime = ft.format(date);
        newUser.setCreateTime(dateTime);
        int insertResult = userMapper.insert(newUser);
        if(insertResult >= 0){



            Long userId = getIdByUsername(user.getUsername());

            RoleEnum roleId = RoleEnum.getRoleEnumByDesc(user.getRoleName());

            if (roleId == null) {
                return Result.failed(HttpStatus.BAD_REQUEST.value(), "用户角色有误");
            }

            UserRole userRole = new UserRole(userId, roleId);



            int result = userRoleMapper.insert(userRole);
            if(result >= 0){
                return Result.success("添加成功", user);
            }
            // else {
            //     return Result.failed(403,"添加失败");
            // }

        }
        return Result.failed(403,"添加失败");
    }

    private Long getIdByUsername(String username) {
        return userMapper.selectIdByUsername(username);
    }

    @Override
    public int countByUsername(String username) {
        return userMapper.countByUsername(username);
    }

    @Override
    public Result<UserForm> deleteUserByID(Integer id) {
        LambdaQueryWrapper<UserRole> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleLambdaQueryWrapper.eq(UserRole::getUserId,id);
        int flag = userRoleMapper.delete(userRoleLambdaQueryWrapper);
        if(flag == 1){
            int deleteResult = userMapper.deleteById(id);
            if(deleteResult == 1){
                return Result.success("删除成功");
            }
            // return Result.failed(403,"删除失败");
        }
        return Result.failed(403,"删除失败");
    }

    @Override
    public Result<UserRoleForm> updateUser(UserRoleForm userRoleForm) {
//        int flag = 1;
        long userID = userRoleForm.getId();
        LambdaQueryWrapper<UserRole> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleLambdaQueryWrapper.eq(UserRole::getUserId,userID);
        UserRole userRole = userRoleMapper.selectOne(userRoleLambdaQueryWrapper);
        Role role = roleMapper.selectById(userRole.getRoleId());
        if(role.getRoleName() != userRoleForm.getRoleName()){
            LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roleLambdaQueryWrapper.eq(Role::getRoleName,userRoleForm.getRoleName());
            long roleID = roleMapper.selectOne(roleLambdaQueryWrapper).getRoleId();
//            userRole.setRoleId(roleID);
            int flagDelete = userRoleMapper.delete(userRoleLambdaQueryWrapper);
            if(flagDelete == 1){
                userRole.setRoleId(RoleEnum.getRoleEnumByValue(userID));
                int flagInsert = userRoleMapper.insert(userRole);
                if(flagInsert == 0) return Result.failed(403,"失败");
            }
            else return Result.failed(403,"失败");
        }
        User userUpdated = new User();
        userUpdated.setId(userRoleForm.getId());
        userUpdated.setName(userRoleForm.getName());
        userUpdated.setUsername(userRoleForm.getUsername());
        userUpdated.setPassword(userRoleForm.getPassword());
        userUpdated.setAge(userRoleForm.getAge());
        userUpdated.setSex(userRoleForm.getSex());
        userUpdated.setPhone(userRoleForm.getPhoneNumber());
        userUpdated.setEmail(userUpdated.getEmail());
        int result = userMapper.updateById(userUpdated);
        if(result == 1){
            return Result.success("更新成功");
        }
        return Result.failed(403,"更新失败");

    }

    @Override
    public Result<UserRoleForm> findUserDetail(long id) {
        UserRoleForm userRoleForm = userMapper.findUserDetailed(id);
        if(userRoleForm != null){
            return Result.success("查询成功",userRoleForm);
        }
        return Result.failed(HttpStatus.NOT_FOUND.value(),"无此用户");
    }

    @Override
    public UserAuthDTO getAuthInfoByUsername(String username) {
        return this.baseMapper.getAuthInfoByUsername(username);
    }
}
