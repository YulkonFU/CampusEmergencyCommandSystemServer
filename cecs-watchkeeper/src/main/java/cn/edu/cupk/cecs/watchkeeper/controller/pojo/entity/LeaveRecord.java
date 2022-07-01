package cn.edu.cupk.cecs.watchkeeper.controller.pojo.entity;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/10:22
 * @Description:
 */
@Data
@TableName("leave_record")
@NoArgsConstructor
public class LeaveRecord {

    @TableId(value = "record_id")
    private long id;

    private long applicant;

    private long verifier;

    @TableField("leave_time")
    private DateTime leaveTime;

    @TableField("leave_start_time")
    private DateTime startTime;

    @TableField("leave_end_time")
    private DateTime endTime;

    @TableField("leave_matter")
    private DateTime matter;

    private Integer status;

    @TableField("audi_reason")
    private String audiReason;

    @TableLogic(value = "0",delval = "1")
    private Integer deleted;
}
