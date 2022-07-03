package cn.edu.cupk.panel.controller;

import cn.edu.cupk.common.result.Result;
import cn.edu.cupk.event.api.EventFeignClient;
import cn.edu.cupk.supply.api.SupplyFeignClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 赵希奥
 * @date 2022/7/2 23:03
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@RestController
@RequestMapping("/panel")
public class PanelController {

    @Resource
    private EventFeignClient eventFeignClient;

    @Resource
    private SupplyFeignClient supplyFeignClient;

    @GetMapping("/times")
    public Result getTimes() {
        return eventFeignClient.getEventTimes();
    }

    @GetMapping("/periods")
    public Result getPeriods() {
        return eventFeignClient.getEventPeriod();
    }

    @GetMapping("/week")
    public Result getWeek() {
        return eventFeignClient.getEventWeek();
    }

    @GetMapping("/remaining")
    public Result getRemaining() {
        return supplyFeignClient.getRemaining();
    }
}
