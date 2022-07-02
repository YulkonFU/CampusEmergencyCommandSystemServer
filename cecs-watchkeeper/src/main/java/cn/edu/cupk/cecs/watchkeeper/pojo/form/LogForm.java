package cn.edu.cupk.cecs.watchkeeper.pojo.form;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.DutyLog;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/23:11
 * @Description:
 */
@Data
public class LogForm extends DutyLog {

    private long userId;

    private String name;

    private String registrationTime;

    private String location;

    @TableField("log_result")
    private String result;
}
