package cn.edu.cupk.supply.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;

/**
 * @author 赵希奥
 * @date 2022/7/3 16:10
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@AllArgsConstructor
public enum SupplyTypeEnum implements IEnum<Integer> {
    XIAOFANG(0, "消防"),
    YILIAO(1, "医疗"),
    JINGYONG(2, "警用");

    @EnumValue
    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public Integer getValue() {
        return this.code;
    }
}
