package cn.edu.cupk.cecs.watchkeeper.mapper;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.Event;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventArray;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventPlanForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/11:31
 * @Description:
 */
@Mapper
public interface EventMapper extends BaseMapper<Event> {

    @Select("SELECT type, level, status, start_time, end_time, location " +
            "FROM event " +
            "WHERE reporter = #{id} " +
            "ORDER BY start_time ASC")
    List<EventArray> searchEventList(@Param("id") long id);


    List<EventPlanForm> findEventsAndPlan();

    int escalation(long eventId,Integer status);
}
