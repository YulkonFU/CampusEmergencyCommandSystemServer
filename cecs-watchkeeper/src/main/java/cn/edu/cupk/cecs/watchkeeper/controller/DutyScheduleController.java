package cn.edu.cupk.cecs.watchkeeper.controller;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.DutySchedule;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.DutyScheduleService;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/21:02
 * @Description:
 */
@Controller
@RequestMapping("/dutySchedule")
public class DutyScheduleController {

    @Autowired
    private DutyScheduleService dutyScheduleService;

    @GetMapping("/currentSchedule")
    @ResponseBody
    public Result<DutySchedule> getCurrentSchedule(long id){
        Date date = new Date();
        String currentDate = DateUtil.format(date,"yyyy-MM-dd");
        return dutyScheduleService.getCurrentSchedule(id, currentDate);
    }
}
