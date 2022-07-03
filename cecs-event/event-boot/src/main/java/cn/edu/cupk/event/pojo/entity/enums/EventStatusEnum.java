package cn.edu.cupk.event.pojo.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;

/**
 * @author 赵希奥
 * @date 2022/7/2 12:20
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@AllArgsConstructor
public enum EventStatusEnum implements IEnum<Integer> {
    // 事件状态（0-待处理；1-处理中；2-响应升级；3-已解决；4-无法解决）
    TO_BE_HANDLED(0, "待处理"),
    HANDLING(1, "处理中"),
    RESPONSE_UPGRADE(2, "响应升级"),
    SOLVED(3, "已解决"),
    UNSOLVABLE(4, "无法解决");

    private int value;
    private String desc;

    public static EventStatusEnum getByValue(int value) {
        for (EventStatusEnum eventStatusEnum : EventStatusEnum.values()) {
            if (eventStatusEnum.getValue() == value) {
                return eventStatusEnum;
            }
        }
        return null;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
