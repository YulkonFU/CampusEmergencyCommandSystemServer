package cn.edu.cupk.cecs.watchkeeper.controller;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.DutyLog;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.LogForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;
import cn.edu.cupk.cecs.watchkeeper.service.DutyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/11:08
 * @Description:
 */
@Controller
@RequestMapping("/weixin/dutyLog")
public class DutyLogController {

    @Autowired
    private DutyLogService dutyLogService;

    @ResponseBody
    @PostMapping("/registration")
    public Result<DutyLog> registerLog(@RequestBody LogForm form){
        return dutyLogService.registerLog(form);
    }

}
