package cn.edu.cupk.cecs.schedule.controller;

import cn.edu.cupk.cecs.schedule.pojo.entity.DutySchedule;
import cn.edu.cupk.cecs.schedule.pojo.utils.PageResult;
import cn.edu.cupk.cecs.schedule.service.DutyScheduleService;
//import cn.hutool.db.PageResult;
import cn.edu.cupk.cecs.schedule.service.impl.DutyScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/21:00
 * @Description:
 */
@RestController
@RequestMapping("/dutySchedule")
public class DutyScheduleController {
    @Autowired
    DutyScheduleServiceImpl dutyScheduleService;
    //查询排班信息
    @ResponseBody
    @GetMapping("/list")
    public PageResult<DutySchedule> getDutySchedule(@RequestParam(defaultValue = "1",value = "pageNum") Integer currentPage,
                                                    @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize,
                                                    @RequestParam(defaultValue = "",value = "str") String str){
        return dutyScheduleService.getDutySchedule(currentPage, pageSize, str);
    }
    //修改排班信息
    @ResponseBody
    @PutMapping("/modification")
    public Boolean updateDutySchedule(@RequestBody DutySchedule dutySchedule){
        return dutyScheduleService.updateDutySchedule(dutySchedule);
    }
    //删除排班信息
    @ResponseBody
    @DeleteMapping("/")
    public Boolean deleteDutySchedule(Integer id){
        return dutyScheduleService.deleteDutySchedule(id);
    }
    //添加排班信息
    @ResponseBody
    @PostMapping("/newDutySchedule")
    public Boolean addNewDutySchedule(@RequestBody DutySchedule dutySchedule){
        return dutyScheduleService.addNewDutySchedule(dutySchedule);
    }

}
