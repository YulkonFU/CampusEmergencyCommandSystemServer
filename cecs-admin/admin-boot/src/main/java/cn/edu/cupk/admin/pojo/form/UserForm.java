package cn.edu.cupk.admin.pojo.form;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

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
    private List<String> roleName;

    private Integer status;
}
