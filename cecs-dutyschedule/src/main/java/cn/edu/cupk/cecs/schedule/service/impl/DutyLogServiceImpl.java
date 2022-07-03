package cn.edu.cupk.cecs.schedule.service.impl;

import cn.edu.cupk.cecs.schedule.mapper.DutyLogMapper;
import cn.edu.cupk.cecs.schedule.pojo.entity.DutyLog;
import cn.edu.cupk.cecs.schedule.pojo.utils.PageResult;
import cn.edu.cupk.cecs.schedule.service.DutyLogService;
//import cn.hutool.db.PageResult;
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
 * @Date：2022/07/03/22:03
 * @Description:
 */
@Service
public class DutyLogServiceImpl implements DutyLogService {

    @Autowired
    private DutyLogMapper dutyLogMapper;
    @Override
    public PageResult<DutyLog> getDutyLog(Integer currentPage, Integer pageSize, String date, String str) {
        LambdaQueryWrapper<DutyLog> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(date != null,DutyLog::getRegistrationTime,date)
                .like(StringUtils.hasText(str),DutyLog::getId,str).or()
                .like(StringUtils.hasText(str),DutyLog::getUserId,str).or()
                .like(StringUtils.hasText(str),DutyLog::getLogResult,str).or()
                .like(StringUtils.hasText(str),DutyLog::getScheduleId,str);
        Page<DutyLog> page = new Page<>(currentPage,pageSize);
        IPage<DutyLog> dutyLogIPage = dutyLogMapper.selectPage(page,wrapper);
        PageResult<DutyLog> result = PageResult.success(dutyLogIPage);
        return result;
    }

    @Override
    public Boolean updateDutyLog(DutyLog dutyLog) {
        int flag = dutyLogMapper.updateById(dutyLog);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteDutyLog(Long id) {
        int flag = dutyLogMapper.deleteById(id);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addNewDutyLog(DutyLog dutyLog) {
        int flag = dutyLogMapper.insert(dutyLog);
        if(flag > 0){
            return true;
        }
        return false;
    }
}
