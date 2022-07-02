package cn.edu.cupk.cecs.watchkeeper.service;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.DutySchedule;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/19:06
 * @Description:
 */
public interface DutyScheduleService {

    Result<DutySchedule> getCurrentSchedule(long id, String currentDate);
}
