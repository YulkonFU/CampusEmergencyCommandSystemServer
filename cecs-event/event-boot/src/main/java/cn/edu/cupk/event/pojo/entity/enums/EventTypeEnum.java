package cn.edu.cupk.event.pojo.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author 赵希奥
 * @date 2022/7/2 11:53
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@AllArgsConstructor
public enum EventTypeEnum implements IEnum<Integer> {

    FIRE(0,"火灾"),

    EXPLOSION(1,"爆炸"),

    LEAKAGE(2,"泄露"),

    TERRORISM(3,"暴恐");
    private int value;

    private String desc;

    public static String getDescByValue(int value) {
        for (EventTypeEnum e : EventTypeEnum.values()) {
            if (value == e.getValue()) {
                return e.desc;
            }
        }
        return null;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
