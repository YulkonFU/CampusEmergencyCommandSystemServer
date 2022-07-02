package cn.edu.cupk.admin.pojo.enums;

import cn.edu.cupk.admin.mapper.RoleMapper;
import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RoleEnum implements IEnum<Integer> {
    ADMIN(1, "管理员"),
    ZONGKONG(2, "总控人员"),
    ZHIBAN(3, "值班人员");

    private int value;

    private String desc;

    public String getDesc() {
        return desc;
    }

    public Integer getVal() {
        return value;
    }


    public static RoleEnum getRoleEnumByDesc(String desc) {
        for (RoleEnum r : RoleEnum.values()) {
            if (r.getDesc().equals(desc)) {
                return r;
            }
        }
        return null;
    }
    public static RoleEnum getRoleEnumByValue(Long id) {
        for (RoleEnum r : RoleEnum.values()) {
            if (r.getVal().equals(Integer.valueOf(id.toString()))) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
