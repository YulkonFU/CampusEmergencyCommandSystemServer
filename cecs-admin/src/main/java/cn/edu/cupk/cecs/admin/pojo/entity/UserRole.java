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
 * @Date：2022/06/28/16:47
 * @Description:用户-角色
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_role")
public class UserRole {
//    @TableId(value = "user_id")
    private long userId;

//    @TableId(value = "role_id")
    private long roleId;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
