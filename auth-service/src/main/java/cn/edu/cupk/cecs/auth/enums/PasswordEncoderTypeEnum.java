package cn.edu.cupk.cecs.auth.enums;

import lombok.Getter;

/**
 * @author 赵希奥
 * @date 2022/6/27 10:58
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public enum PasswordEncoderTypeEnum {
    BCCRYPT("{bcrypt}", "BCRYPT加密"),
    NOOP("{noop}", "无加密");

    @Getter
    private String prefix;
    @Getter
    private String description;

    PasswordEncoderTypeEnum(String prefix, String description) {
        this.prefix = prefix;
    }
}
