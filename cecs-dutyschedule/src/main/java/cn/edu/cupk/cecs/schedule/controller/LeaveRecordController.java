package cn.edu.cupk.cecs.schedule.controller;

//import cn.edu.cupk.cecs.schedule.pojo.entity.leaveRecord;
import cn.edu.cupk.cecs.schedule.pojo.entity.LeaveRecord;
import cn.edu.cupk.cecs.schedule.pojo.utils.PageResult;
import cn.edu.cupk.cecs.schedule.service.DutyLogService;
import cn.edu.cupk.cecs.schedule.service.impl.LeaveRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/22:10
 * @Description:
 */
@RestController
@RequestMapping("/leaveRecord")
public class LeaveRecordController {


    @Autowired
    private LeaveRecordServiceImpl leaveRecordService;
    //查询值班日志
    @GetMapping("/list")
    @ResponseBody
    public PageResult<LeaveRecord> getLeaveRecord(@RequestParam(defaultValue = "1",value = "pageNum") Integer currentPage,
                                          @RequestParam(defaultValue = "5",value = "pageSize") Integer pageSize,
                                          @RequestParam(defaultValue = "",value = "date") String date,
                                          @RequestParam(defaultValue = "",value = "str") String str){
        return leaveRecordService.getLeaveRecord(currentPage,pageSize,date,str);
    }

    //修改排班信息
    @ResponseBody
    @PutMapping("/modification")
    public Boolean updateLeaveRecord(@RequestBody LeaveRecord leaveRecord){
        return leaveRecordService.updateLeaveRecord(leaveRecord);
    }
    //删除排班信息
    @ResponseBody
    @DeleteMapping("/")
    public Boolean deleteLeaveRecord(Long id){

        return leaveRecordService.deleteLeaveRecord(id);
    }
    //添加排班信息
    @ResponseBody
    @PostMapping("/newLeaveRecord")
    public Boolean addNewLeaveRecord(@RequestBody LeaveRecord leaveRecord){
        return leaveRecordService.addNewLeaveRecord(leaveRecord);
    }
}
