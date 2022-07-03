package cn.edu.cupk.cecs.schedule.service;

import cn.edu.cupk.cecs.schedule.pojo.entity.DutyLog;
import cn.edu.cupk.cecs.schedule.pojo.entity.DutySchedule;
import cn.edu.cupk.cecs.schedule.pojo.utils.PageResult;
//import cn.hutool.db.PageResult;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/22:03
 * @Description:
 */
public interface DutyLogService {
    PageResult<DutyLog> getDutyLog(Integer currentPage, Integer pageSize, String date, String str);

    Boolean updateDutyLog(DutyLog dutyLog);
    //删除对象
    Boolean deleteDutyLog(Long id);

    Boolean addNewDutyLog(DutyLog dutyLog);
}
