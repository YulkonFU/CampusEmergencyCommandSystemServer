package cn.edu.cupk.cecs.admin.pojo.form;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/06/30/9:25
 * @Description:
 */
@Data
public class UserForm {

    private long id;

    private String username;

    @JsonIgnore
    private String password;

    private String name;

    @TableField("role_name")
    private String roleName;

//    private Integer status;

    private Integer age;

    private Integer sex;

    @TableField("create_time")
    private String creatTime;

    @TableField("phone_number")
    private String phoneNumber;

    private String email;
}
