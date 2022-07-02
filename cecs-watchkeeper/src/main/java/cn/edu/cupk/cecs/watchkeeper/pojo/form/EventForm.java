package cn.edu.cupk.cecs.watchkeeper.pojo.form;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.Event;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/17:34
 * @Description:
 */
@Data
public class EventForm extends Event {

    private long reporter;

    @TableField("start_time")
    private String startTime;

    private String location;

    private String description;

    private Integer type;

    private Integer level;

    private Integer status;
}
