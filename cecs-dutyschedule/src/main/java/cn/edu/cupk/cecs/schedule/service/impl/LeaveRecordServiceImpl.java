package cn.edu.cupk.cecs.schedule.service.impl;

import cn.edu.cupk.cecs.schedule.mapper.LeaveRecordMapper;
import cn.edu.cupk.cecs.schedule.pojo.entity.DutyLog;
import cn.edu.cupk.cecs.schedule.pojo.entity.LeaveRecord;
import cn.edu.cupk.cecs.schedule.pojo.utils.PageResult;
import cn.edu.cupk.cecs.schedule.service.LeaveRecordService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/04/1:41
 * @Description:
 */
@Service
public class LeaveRecordServiceImpl implements LeaveRecordService {

    @Autowired
    private LeaveRecordMapper leaveRecordMapper;
    @Override
    public PageResult<LeaveRecord> getLeaveRecord(Integer currentPage, Integer pageSize, String date, String str) {
        LambdaQueryWrapper<LeaveRecord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(date != null,LeaveRecord::getLeaveDate,date)
                .like(StringUtils.hasText(str),LeaveRecord::getRecordId,str).or()
                .like(StringUtils.hasText(str),LeaveRecord::getLeaveMatter,str).or()
                .like(StringUtils.hasText(str),LeaveRecord::getLeaveEndTime,str).or()
                .like(StringUtils.hasText(str),LeaveRecord::getLeaveStartTime,str).or()
                .like(StringUtils.hasText(str),LeaveRecord::getApplicant,str).or()
                .like(StringUtils.hasText(str),LeaveRecord::getAuditReason,str).or()
                .like(StringUtils.hasText(str),LeaveRecord::getStatus,str).or()
                .like(StringUtils.hasText(str),LeaveRecord::getVerifier,str);
        Page<LeaveRecord> page = new Page<>(currentPage,pageSize);
        IPage<LeaveRecord> leaveRecordIPage = leaveRecordMapper.selectPage(page,wrapper);
        PageResult<LeaveRecord> result = PageResult.success(leaveRecordIPage);
        return result;
    }

    @Override
    public Boolean updateLeaveRecord(LeaveRecord leaveRecord) {
        int flag = leaveRecordMapper.updateById(leaveRecord);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteLeaveRecord(Long id) {
        int flag = leaveRecordMapper.deleteById(id);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addNewLeaveRecord(LeaveRecord leaveRecord) {
        int flag = leaveRecordMapper.insert(leaveRecord);
        if(flag > 0){
            return true;
        }
        return false;
    }
}
