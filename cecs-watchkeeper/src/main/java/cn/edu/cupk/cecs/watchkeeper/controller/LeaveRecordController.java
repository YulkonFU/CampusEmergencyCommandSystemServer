package cn.edu.cupk.cecs.watchkeeper.controller;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.LeaveRecord;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.LeaveApplicationForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.LeaveRecordService;
import cn.edu.cupk.cecs.watchkeeper.service.impl.LeaveRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/22:49
 * @Description:
 */
@Controller
@RequestMapping("/leave")
public class LeaveRecordController {

    @Autowired
    private LeaveRecordServiceImpl leaveRecordService;

    @PostMapping("/application")
    @ResponseBody
    public Result<LeaveRecord> applyForLeave(LeaveApplicationForm form){
        return leaveRecordService.applyForLeave(form);
    }
}
