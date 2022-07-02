package cn.edu.cupk.cecs.watchkeeper.pojo.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：2022/07/01/22:00
 * @Description:
 */
@Data
@NoArgsConstructor
public class EventList {

    private Integer total;

    private List<EventArray> list;
}
