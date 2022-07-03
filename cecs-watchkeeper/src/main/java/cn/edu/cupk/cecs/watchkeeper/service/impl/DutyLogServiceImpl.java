package cn.edu.cupk.cecs.watchkeeper.service.impl;

import cn.edu.cupk.cecs.watchkeeper.mapper.DutyLogMapper;
import cn.edu.cupk.cecs.watchkeeper.mapper.DutyScheduleMapper;
import cn.edu.cupk.cecs.watchkeeper.pojo.entity.DutyLog;
import cn.edu.cupk.cecs.watchkeeper.pojo.entity.DutySchedule;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.LogForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.DutyLogService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/02/0:31
 * @Description:
 */
@Service
public class DutyLogServiceImpl implements DutyLogService {

    @Autowired
    private DutyLogMapper dutyLogMapper;

    @Autowired
    private DutyScheduleMapper dutyScheduleMapper;
    @Override
    public Result<DutyLog> registerLog(LogForm form) {
        LambdaQueryWrapper<DutySchedule> wrapper = new LambdaQueryWrapper<>();
        Date date = new Date();
        String str = DateUtil.format(date,"yyyy-MM-dd");
        wrapper.eq(DutySchedule::getUserId,form.getUserId())
                .eq(DutySchedule::getDutyDate,str);
        DutySchedule schedule = dutyScheduleMapper.selectOne(wrapper);
        DutyLog dutyLog = new DutyLog();
        dutyLog.setScheduleId(schedule.getId());
        dutyLog.setUserId(form.getUserId());
        dutyLog.setResult(form.getResult());
        dutyLog.setRegistrationTime(form.getRegistrationTime());
        int flag = dutyLogMapper.insert(dutyLog);
        if(flag == 1){
            return Result.success("打卡成功",dutyLog);
        }
        return Result.failed(403,"打卡失败");
    }
}
