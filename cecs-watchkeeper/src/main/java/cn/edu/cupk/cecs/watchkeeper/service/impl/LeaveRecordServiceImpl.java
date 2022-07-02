package cn.edu.cupk.cecs.watchkeeper.service.impl;

import cn.edu.cupk.cecs.watchkeeper.mapper.LeaveRecordMapper;
import cn.edu.cupk.cecs.watchkeeper.pojo.entity.LeaveRecord;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.LeaveApplicationForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.LeaveRecordService;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/22:33
 * @Description:
 */
@Service
public class LeaveRecordServiceImpl implements LeaveRecordService {

    @Autowired
    private LeaveRecordMapper leaveRecordMapper;

    @Override
    public Result<LeaveRecord> applyForLeave(LeaveApplicationForm form) {
        Date date = new Date();
        String currentDate = DateUtil.format(date,"yyyy-MM-dd");
        form.setLeaveDate(currentDate);
        int flag = leaveRecordMapper.insert(form);
        if(flag == 1){
            LambdaQueryWrapper<LeaveRecord> leaveRecordLambdaQueryWrapper = new LambdaQueryWrapper<>();
            leaveRecordLambdaQueryWrapper.eq(LeaveRecord::getLeaveDate,currentDate)
                    .eq(LeaveRecord::getApplicant,form.getApplicant())
                    .eq(LeaveRecord::getStartTime,form.getStartTime());
            LeaveRecord leaveRecord = leaveRecordMapper.selectOne(leaveRecordLambdaQueryWrapper);
            Result<LeaveRecord> result = Result.success(leaveRecord);
            return result;
        }

        return Result.failed(403,"失败");
    }
}
