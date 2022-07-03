package cn.edu.cupk.cecs.schedule.mapper;

import cn.edu.cupk.cecs.schedule.pojo.entity.DutySchedule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/21:05
 * @Description:
 */
@Mapper
public interface DutyScheduleMapper extends BaseMapper<DutySchedule> {
    //返回dutySchedule列表
//    IPage<DutySchedule> getDutySchedule(String str);


}
