package cn.edu.cupk.event.pojo.entity;

import cn.edu.cupk.event.pojo.entity.enums.EventLevelEnum;
import cn.edu.cupk.event.pojo.entity.enums.EventStatusEnum;
import cn.edu.cupk.event.pojo.entity.enums.EventTypeEnum;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 赵希奥
 * @date 2022/7/2 11:38
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Data
@TableName("event")
public class Event {
    @TableId(value="event_id", type= IdType.AUTO)
    private Long eventId;

    @TableField("plan_id")
    private Long planId;

    @TableField("reporter")
    private Long reporter;

    @TableField("type")
    private EventTypeEnum type;

    @TableField(value = "start_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime startTime;

    @TableField(value = "end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;

    @TableField(value = "description")
    private String description;

    @TableLogic
    private Integer deleted;

    @TableField("location")
    private String location;

    @TableField("commander")
    private Long commander;

    @TableField("level")
    private EventLevelEnum level;

    @TableField("status")
    private EventStatusEnum status;

}
