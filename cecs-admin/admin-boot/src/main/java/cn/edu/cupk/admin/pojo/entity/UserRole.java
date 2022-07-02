package cn.edu.cupk.admin.pojo.entity;


import cn.edu.cupk.admin.pojo.enums.RoleEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/28/16:47
 * @Description:用户-角色
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_role")
public class UserRole {
//    @TableId(value = "user_id")
    @TableField("user_id")
    private Long userId;

//    @TableId(value = "role_id")
    @TableField("role_id")
    private RoleEnum roleId;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    public UserRole(Long userId, RoleEnum roleId) {
        this.deleted = 0;
        this.userId = userId;
        this.roleId = roleId;
    }
}
