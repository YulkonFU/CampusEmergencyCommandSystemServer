package cn.edu.cupk.common.enums;

/**
 * @author 赵希奥
 * @date 2022/6/29 6:22
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
import cn.edu.cupk.common.base.IBaseEnum;
import lombok.Getter;

/**
 * 认证身份标识枚举
 *
 * @author haoxr
 * @date 2021/10/4
 */
public enum AuthenticationIdentityEnum implements IBaseEnum<String> {

    USERNAME("username", "用户名"),
    MOBILE("mobile", "手机号"),
    OPENID("openId", "开放式认证系统唯一身份标识");

    @Getter
    private String value;

    @Getter
    private String label;

    AuthenticationIdentityEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }
}