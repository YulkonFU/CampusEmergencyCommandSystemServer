package cn.edu.cupk.cecs.watchkeeper.service.impl;

import cn.edu.cupk.cecs.watchkeeper.mapper.DutyScheduleMapper;
import cn.edu.cupk.cecs.watchkeeper.pojo.entity.DutySchedule;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.DutyScheduleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/19:10
 * @Description:
 */
@Service
public class DutyScheduleServiceImpl implements DutyScheduleService {

    @Autowired
    private DutyScheduleMapper dutyScheduleMapper;

    @Override
    public Result<DutySchedule> getCurrentSchedule(long id, String currentDate) {

        LambdaQueryWrapper<DutySchedule> dutyScheduleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dutyScheduleLambdaQueryWrapper.eq(DutySchedule::getUserId,id)
                .eq(DutySchedule::getDutyDate,currentDate);
        DutySchedule dutySchedule = dutyScheduleMapper.selectOne(dutyScheduleLambdaQueryWrapper);
        Result<DutySchedule> result = Result.success(dutySchedule);
        return  result;
    }
}
