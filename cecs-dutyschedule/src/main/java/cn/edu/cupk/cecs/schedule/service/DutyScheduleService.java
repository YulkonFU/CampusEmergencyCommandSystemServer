package cn.edu.cupk.cecs.schedule.service;

import cn.edu.cupk.cecs.schedule.pojo.entity.DutySchedule;
import cn.edu.cupk.cecs.schedule.pojo.utils.PageResult;
//import cn.hutool.db.PageResult;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/21:17
 * @Description:
 */
public interface DutyScheduleService {
    //获取列表
    PageResult<DutySchedule> getDutySchedule(Integer currentPage, Integer pageSize, String str);
    //修改对象
    Boolean updateDutySchedule(DutySchedule dutySchedule);
    //删除对象
    Boolean deleteDutySchedule(Integer id);

    Boolean addNewDutySchedule(DutySchedule dutySchedule);
}
