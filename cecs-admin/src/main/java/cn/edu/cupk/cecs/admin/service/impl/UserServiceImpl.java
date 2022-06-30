package cn.edu.cupk.cecs.admin.service.impl;

import cn.edu.cupk.cecs.admin.mapper.RoleMapper;
import cn.edu.cupk.cecs.admin.mapper.UserRoleMapper;
import cn.edu.cupk.cecs.admin.pojo.entity.Role;
import cn.edu.cupk.cecs.admin.pojo.entity.UserRole;
import cn.edu.cupk.cecs.admin.pojo.form.UserForm;
import cn.edu.cupk.cecs.admin.pojo.form.UserRoleForm;
import cn.edu.cupk.cecs.admin.pojo.utils.PageResult;
import cn.edu.cupk.cecs.admin.pojo.entity.User;
import cn.edu.cupk.cecs.admin.mapper.UserMapper;
import cn.edu.cupk.cecs.admin.pojo.utils.Result;
import cn.edu.cupk.cecs.admin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/29/16:34
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public PageResult findUserList(Integer currentPage, Integer pageSize, String str, Integer status){
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
        PageResult result = PageResult.success(userIPage);
        return  result;
    }

    @Override
    public Result<UserRoleForm> addNewUser(UserRoleForm user){
        User newUser = new User();

        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
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
        if(insertResult == 1){
            UserRole userRole = new UserRole();
            LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userLambdaQueryWrapper.eq(User::getName,newUser.getName()).eq(User::getUsername,newUser.getUsername());
            User userFound = userMapper.selectOne(userLambdaQueryWrapper);
            LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
            roleLambdaQueryWrapper.eq(Role::getRoleName, user.getRoleName());
            Role role = roleMapper.selectOne(roleLambdaQueryWrapper);
            userRole.setUserId(userFound.getUserId());
            userRole.setRoleId(role.getRoleId());
            int result = userRoleMapper.insert(userRole);
            if(result == 1){
               return Result.success(user);
            }
            else return Result.failed(403,"失败");
        }
        return Result.failed(403,"失败");
    }

    @Override
    public Result<UserForm> deleteUserByID(Integer id) {
//        int flag = userRoleM
        LambdaQueryWrapper<UserRole> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userRoleLambdaQueryWrapper.eq(UserRole::getUserId,id);
        int flag = userRoleMapper.delete(userRoleLambdaQueryWrapper);
        if(flag == 1){
            int deleteResult = userMapper.deleteById(id);
            if(deleteResult == 1){
                return Result.success("成功");
            }
            return Result.failed(403,"失败");
        }
        return Result.failed(403,"失败");
    }

    @Override
    public Result<UserRoleForm> updateUser(UserRoleForm userRoleForm){
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
                userRole.setRoleId(roleID);
                int flagInsert = userRoleMapper.insert(userRole);
                if(flagInsert == 0) return Result.failed(403,"失败");
            }
            else return Result.failed(403,"失败");
        }
        User userUpdated = new User();
        userUpdated.setUserId(userRoleForm.getId());
        userUpdated.setName(userRoleForm.getName());
        userUpdated.setUsername(userRoleForm.getUsername());
        userUpdated.setPassword(userRoleForm.getPassword());
        userUpdated.setAge(userRoleForm.getAge());
        userUpdated.setSex(userRoleForm.getSex());
        userUpdated.setPhone(userRoleForm.getPhoneNumber());
        userUpdated.setEmail(userUpdated.getEmail());
        int result = userMapper.updateById(userUpdated);
        if(result == 1){
            return Result.success("成功");
        }
        return Result.failed(403,"失败");
    }

    public Result<UserRoleForm> findUserDetail(long id){
        UserRoleForm userRoleForm = userMapper.findUserDetailed(id);
        return Result.success("成功",userRoleForm);
    }
}
