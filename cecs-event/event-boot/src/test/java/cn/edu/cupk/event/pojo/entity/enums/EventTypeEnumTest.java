package cn.edu.cupk.event.pojo.entity.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 赵希奥
 * @date 2022/7/3 3:05
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
class EventTypeEnumTest {

    @Test
    void getDescByValue() {
        String desc = EventTypeEnum.getDescByValue(1);
        System.out.println(desc);
    }
}