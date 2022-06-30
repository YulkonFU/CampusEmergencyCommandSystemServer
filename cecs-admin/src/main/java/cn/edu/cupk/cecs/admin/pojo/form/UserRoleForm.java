package cn.edu.cupk.cecs.admin.pojo.form;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/30/11:15
 * @Description:
 */
@Data
public class UserRoleForm {

    private long id;

    private String username;

    private String password;

    private String name;

    private Integer sex;

    private Integer age;

    private String phoneNumber;

    private String email;

    @TableField("role_name")
    private String roleName;
}
