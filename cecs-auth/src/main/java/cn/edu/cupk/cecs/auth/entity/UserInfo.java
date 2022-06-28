package cn.edu.cupk.cecs.auth.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 赵希奥
 * @date 2022/6/27 12:55
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Data
@TableName("user")
public class UserInfo implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableLogic("deleted")
    private Integer deleted;
}
