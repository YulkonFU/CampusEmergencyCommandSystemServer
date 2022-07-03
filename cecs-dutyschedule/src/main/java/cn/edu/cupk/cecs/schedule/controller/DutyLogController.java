package cn.edu.cupk.cecs.schedule.controller;

import cn.edu.cupk.cecs.schedule.pojo.entity.DutyLog;
import cn.edu.cupk.cecs.schedule.pojo.entity.DutySchedule;
import cn.edu.cupk.cecs.schedule.pojo.utils.PageResult;
import cn.edu.cupk.cecs.schedule.service.DutyLogService;
//import cn.hutool.db.PageResult;
import cn.edu.cupk.cecs.schedule.service.impl.DutyLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/21:43
 * @Description:
 */
@RestController
@RequestMapping("/dutyLog")
public class DutyLogController {
    @Autowired
    DutyLogServiceImpl dutyLogService;
    //查询值班日志
    @GetMapping("/list")
    @ResponseBody
    public PageResult<DutyLog> getDutyLog(@RequestParam(defaultValue = "1",value = "pageNum") Integer currentPage,
                                          @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize,
                                          @RequestParam(defaultValue = "",value = "date") String date,
                                          @RequestParam(defaultValue = "",value = "str") String str){
        return dutyLogService.getDutyLog(currentPage,pageSize,date,str);
    }

    //修改排班信息
    @ResponseBody
    @PutMapping("/modification")
    public Boolean updateDutyLog(@RequestBody  DutyLog dutyLog){

        return dutyLogService.updateDutyLog(dutyLog);
    }
    //删除排班信息
    @ResponseBody
    @DeleteMapping("/")
    public Boolean deleteDutyLog(Long id){

        return dutyLogService.deleteDutyLog(id);
    }
    //添加排班信息
    @ResponseBody
    @PostMapping("/newDutyLog")
    public Boolean addNewDutyLog(@RequestBody DutyLog dutyLog){
        return dutyLogService.addNewDutyLog(dutyLog);
    }
}
