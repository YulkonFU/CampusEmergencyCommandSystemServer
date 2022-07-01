package cn.edu.cupk.cecs.watchkeeper.controller.pojo.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/10:21
 * @Description:
 */
@Data
@TableName("duty_log")
@NoArgsConstructor
public class DutyLog {

    @TableId(value = "log_id",type = IdType.AUTO)
    private long id;

    @TableField("user_id")
    private long userId;

    @TableField("schedule_id")
    private long scheduleId;

    @TableField("registration_time")
    private DateTime registrationTime;

    @TableField("log_result")
    private String result;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
