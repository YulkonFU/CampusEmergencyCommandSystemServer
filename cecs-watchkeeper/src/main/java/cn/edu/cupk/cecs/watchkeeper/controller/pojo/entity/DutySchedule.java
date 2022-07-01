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
@TableName("duty_schedule")
@NoArgsConstructor
public class DutySchedule {

    @TableId(value = "schedule_id",type = IdType.AUTO)
    private long id;

    @TableField("user_id")
    private long userId;

    @TableField("duty_place")
    private String dutyPlace;

    @TableField("schedule_start_time")
    private DateTime startTime;

    @TableField("schedule_end_time")
    private DateTime endTime;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
