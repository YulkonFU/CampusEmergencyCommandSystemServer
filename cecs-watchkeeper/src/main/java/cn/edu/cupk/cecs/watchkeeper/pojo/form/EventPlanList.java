package cn.edu.cupk.cecs.watchkeeper.pojo.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/03/10:30
 * @Description:
 */
@Data
@NoArgsConstructor
public class EventPlanList {

    private Integer total;

    private List<EventPlanForm> list;
}
