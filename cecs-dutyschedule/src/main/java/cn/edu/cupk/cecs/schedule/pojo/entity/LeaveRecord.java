package cn.edu.cupk.cecs.schedule.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/04/0:19
 * @Description:
 */
@Data
@TableName("leave_record")
public class LeaveRecord {
    @TableId(value = "record_id",type = IdType.AUTO)
    private Long recordId;


    private Long applicant;

    private Long verifier;

    @TableField("leave_date")
    private String leaveDate;

    @TableField("leave_start_time")
    private String leaveStartTime;

    @TableField("leave_end_time")
    private String leaveEndTime;

    @TableField("leave_matter")
    private String leaveMatter;

    private Integer status;

    @TableField("audit_reason")
    private String auditReason;

    private Integer deleted;
}
