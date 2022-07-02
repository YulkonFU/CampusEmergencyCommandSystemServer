package cn.edu.cupk.cecs.watchkeeper.pojo.form;

import cn.edu.cupk.cecs.watchkeeper.pojo.entity.Event;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/21:17
 * @Description:
 */
@Data
public class EventArray extends Event {

    private Integer type;

    private Integer level;

    private Integer status;

    @TableField("start_time")
    private String startTime;

    @TableField("end_time")
    private String endTime;

    private String location;
}
