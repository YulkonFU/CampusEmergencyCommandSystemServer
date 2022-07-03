package cn.edu.cupk.cecs.watchkeeper.pojo.form;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.Event;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/9:57
 * @Description:
 */

@Data
public class EventPlanForm extends Event {
    private long id;

    private Integer type;

    @TableField("start_time")
    private String startTime;

    private String location;

    @TableField("content")
    private String planContent;
}
