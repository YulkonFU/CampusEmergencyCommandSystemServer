package cn.edu.cupk.event.mapper;

import cn.edu.cupk.event.pojo.dto.EventTimesItemDTO;
import cn.edu.cupk.event.pojo.entity.Event;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author 赵希奥
 * @date 2022/7/2 15:35
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */


@Mapper
public interface EventMapper extends BaseMapper<Event> {

    List<Map<String, Object> > getEventTimes();

    List<Map<String, Integer>> getEventPeriod();

    List<EventTimesItemDTO> getWeekEvent();
}

