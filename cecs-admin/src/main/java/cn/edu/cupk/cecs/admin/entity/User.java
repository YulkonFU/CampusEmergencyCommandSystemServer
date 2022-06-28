package cn.edu.cupk.cecs.admin.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/28/16:44
 * @Description:用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private long userId;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("name")
    private String name;

    @TableField("sex")
    private Integer sex;

    @TableField("age")
    private Integer age;

    @TableField("email")
    private String email;

    @TableField("phone_number")
    private String phone;
    private Integer status;

    @TableField("create_time")
    private String createTime;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
