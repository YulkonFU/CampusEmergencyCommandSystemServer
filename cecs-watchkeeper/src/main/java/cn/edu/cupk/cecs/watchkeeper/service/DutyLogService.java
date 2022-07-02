package cn.edu.cupk.cecs.watchkeeper.service;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.DutyLog;
import cn.edu.cupk.cecs.watchkeeper.pojo.form.LogForm;
import cn.edu.cupk.cecs.watchkeeper.pojo.tools.Result;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/02/0:27
 * @Description:
 */
public interface DutyLogService {

    Result<DutyLog> registerLog(LogForm form);
}
