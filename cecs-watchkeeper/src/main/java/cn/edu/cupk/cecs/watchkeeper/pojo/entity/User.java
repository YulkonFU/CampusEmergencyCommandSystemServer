package cn.edu.cupk.cecs.watchkeeper.pojo.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/10:19
 * @Description:
 */
@Data
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private long id;

    private String username;

    private String password;

    private String name;

    private Integer sex;

    private Integer age;

    private String email;

    @TableField("phone_number")
    private String phoneNumber;

    private Integer status;

    @TableField("create_time")
    private String createTime;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
