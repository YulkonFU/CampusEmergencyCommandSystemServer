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
@TableName("event")
@NoArgsConstructor
public class Event {

    @TableId(value = "event_id",type = IdType.AUTO)
    private long id;

    @TableField("plan_id")
    private long planId;

    private long reporter;

    private long commander;

    private Integer type;

    @TableField("start_time")
    private String startTime;

    @TableField("end_time")
    private String endTime;

    private String location;

    private Integer level;

    private String description;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
