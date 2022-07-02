package cn.edu.cupk.cecs.watchkeeper.service;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.Event;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventArray;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.EventList;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;

import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/17:41
 * @Description:
 */
public interface EventService {

    Result<Event> reportIncident(EventForm eventForm);

    Result<EventList> searchEvents(long userId);
}
