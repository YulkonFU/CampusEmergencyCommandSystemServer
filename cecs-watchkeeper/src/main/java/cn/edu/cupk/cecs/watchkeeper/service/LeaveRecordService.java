package cn.edu.cupk.cecs.watchkeeper.service;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.LeaveRecord;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.LeaveApplicationForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/22:21
 * @Description:
 */
public interface LeaveRecordService {

//    To apply for leave
    Result<LeaveRecord> applyForLeave(LeaveApplicationForm form);
}
