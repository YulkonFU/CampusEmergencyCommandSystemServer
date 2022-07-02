package cn.edu.cupk.admin.mapper;

import cn.edu.cupk.admin.pojo.entity.User;
import cn.edu.cupk.admin.dto.UserAuthDTO;
import cn.edu.cupk.admin.pojo.form.UserForm;
import cn.edu.cupk.admin.pojo.form.UserRoleForm;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author 赵希奥
 * @date 2022/6/29 11:49
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    UserAuthDTO getAuthInfoByUsername(String username);

    /**
     * @Description: 查询用户列表，分页显示
     * @Param: [page, state]
     * @return: com.baomidou.mybatisplus.core.metadata.IPage<cn.edu.cupk.cecs.admin.entity.User>
     * @Author: rst
     * @Date: 2022/6/29
     */
    @Select("SELECT * " +
            " FROM user, user_role, role " +
            " ${ew.customSqlSegment} ")
    IPage<UserForm> findUser(Page<UserForm> userPage, @Param("ew") LambdaQueryWrapper<User> userLambdaQueryWrapper);

    UserRoleForm findUserDetailed(long id);

    /**
     * 使用username查询用户数量
     * @param username
     * @return
     */
    @Select("SELECT COUNT(*) FROM user WHERE username = #{username}")
    int countByUsername(String username);
}