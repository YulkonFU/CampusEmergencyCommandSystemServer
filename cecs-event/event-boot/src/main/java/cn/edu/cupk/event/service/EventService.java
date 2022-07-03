package cn.edu.cupk.event.service;

import cn.edu.cupk.common.result.PageResult;
import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.pojo.entity.Event;
import cn.edu.cupk.event.pojo.query.EventPageQuery;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 赵希奥
 * @date 2022/7/2 16:28
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public interface EventService extends IService<Event> {
    PageResult listEventPages(EventPageQuery queryParams);

    Result getEventTimes();

    Result getEventPeriod();

    Result getEventWeek();
}
