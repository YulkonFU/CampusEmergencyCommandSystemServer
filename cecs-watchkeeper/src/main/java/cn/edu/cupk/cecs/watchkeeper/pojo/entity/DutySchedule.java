package cn.edu.cupk.cecs.watchkeeper.pojo.entity;

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

    @TableField("duty_date")
    private String dutyDate;

    @TableField("duty_start_time")
    private String startTime;

    @TableField("duty_end_time")
    private String endTime;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
