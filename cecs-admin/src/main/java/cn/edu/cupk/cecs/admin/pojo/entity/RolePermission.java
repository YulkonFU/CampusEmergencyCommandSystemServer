package cn.edu.cupk.cecs.admin.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/28/16:48
 * @Description:角色-权限
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role_permission")
public class RolePermission {
//    @TableId(value = "role_id")
    private long roleId;

//    @TableId(value = "permission_id")
    private long permissionId;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;


}
