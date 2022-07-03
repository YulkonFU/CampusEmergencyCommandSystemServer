package cn.edu.cupk.cecs.schedule.service;

import cn.edu.cupk.cecs.schedule.pojo.entity.DutyLog;
import cn.edu.cupk.cecs.schedule.pojo.entity.LeaveRecord;
import cn.edu.cupk.cecs.schedule.pojo.utils.PageResult;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/04/1:38
 * @Description:
 */
public interface LeaveRecordService {

    PageResult<LeaveRecord> getLeaveRecord(Integer currentPage, Integer pageSize, String date, String str);

    Boolean updateLeaveRecord(LeaveRecord leaveRecord);
    //删除对象
    Boolean deleteLeaveRecord(Long id);

    Boolean addNewLeaveRecord(LeaveRecord leaveRecord);
}
