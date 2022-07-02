package cn.edu.cupk.cecs.watchkeeper.pojo.form;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.LeaveRecord;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/22:26
 * @Description:
 */
@Data
public class LeaveApplicationForm extends LeaveRecord {

    @TableField("applicant")
    private  long applicant;

    @TableField("leave_date")
    private String leaveDate;

    @TableField("type")
    private Integer type;

    @TableField("leave_start_time")
    private String startTime;

    @TableField("leave_end_time")
    private String endTime;

    @TableField("leave_matter")
    private String reason;
}
