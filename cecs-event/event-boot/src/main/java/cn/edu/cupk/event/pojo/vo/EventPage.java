package cn.edu.cupk.event.pojo.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 赵希奥
 * @date 2022/7/2 15:58
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class EventPage<T> extends Page<T> {
    //todo 此处后续应再优化

    private Integer selectInt;

    private String selectString;

    private String name;

    public EventPage(long current, long size) {
        super(current, size);
    }
}
