package cn.edu.cupk.cecs.schedule.service.impl;

import cn.edu.cupk.cecs.schedule.mapper.DutyScheduleMapper;
import cn.edu.cupk.cecs.schedule.pojo.entity.DutySchedule;
import cn.edu.cupk.cecs.schedule.pojo.utils.PageResult;
import cn.edu.cupk.cecs.schedule.service.DutyScheduleService;
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
 * @Date：2022/07/03/23:37
 * @Description:
 */
@Service
public class DutyScheduleServiceImpl implements DutyScheduleService {

    @Autowired
    private DutyScheduleMapper dutyScheduleMapper;
    @Override
    public PageResult<DutySchedule> getDutySchedule(Integer currentPage, Integer pageSize, String str) {
        LambdaQueryWrapper<DutySchedule> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(str),DutySchedule::getId,str).or()
                .like(StringUtils.hasText(str),DutySchedule::getUserid,str).or()
                .like(StringUtils.hasText(str),DutySchedule::getDutyDate,str).or()
                .like(StringUtils.hasText(str),DutySchedule::getDutyPlace,str).or()
                .like(StringUtils.hasText(str),DutySchedule::getStartTime,str).or()
                .like(StringUtils.hasText(str),DutySchedule::getEndTime,str);
        Page<DutySchedule> page = new Page<>(currentPage, pageSize);
        IPage<DutySchedule> dutyScheduleIPage = dutyScheduleMapper.selectPage(page, wrapper);
        PageResult<DutySchedule> result = PageResult.success(dutyScheduleIPage);
        return result;
    }

    @Override
    public Boolean updateDutySchedule(DutySchedule dutySchedule) {
        int flag = dutyScheduleMapper.updateById(dutySchedule);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteDutySchedule(Integer id) {
        int flag = dutyScheduleMapper.deleteById(id);
        if(flag > 0){
            return true;
        }
        return false;
    }

    @Override
    public Boolean addNewDutySchedule(DutySchedule dutySchedule) {
        int flag = dutyScheduleMapper.insert(dutySchedule);
        if(flag > 0){
            return true;
        }
        return false;
    }
}
