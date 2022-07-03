package cn.edu.cupk.cecs.schedule.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/21:44
 * @Description:
 */
@Data
public class DutyLog {
    @TableId(value = "log_id",type = IdType.AUTO)
    private Long id;
    @TableField("user_id")
    private Integer userId;
    @TableField("registration_time")
    private Integer registrationTime;
    @TableField("schedule_id")
    private Integer scheduleId;
    @TableField("log_result")
    private String logResult;
}
