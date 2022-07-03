package cn.edu.cupk.event.pojo.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author 赵希奥
 * @date 2022/7/2 12:16
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@AllArgsConstructor
public enum EventLevelEnum implements IEnum<Integer> {
    // todo 事件程度

    SMALL(0, "小"),
    MIDDLE(1, "中"),
    BIG(2, "大");

    private int value;
    private String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }
}
