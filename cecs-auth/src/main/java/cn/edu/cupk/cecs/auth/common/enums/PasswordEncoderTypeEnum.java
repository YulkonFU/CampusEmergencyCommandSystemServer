package cn.edu.cupk.cecs.auth.common.enums;

import lombok.Getter;

/**
 * @author 赵希奥
 * @date 2022/6/29 5:42
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
public enum PasswordEncoderTypeEnum {
    BCRYPT("{bcrypt}","BCRYPT加密"),
    NOOP("{noop}","无加密明文");

    @Getter
    private String prefix;

    PasswordEncoderTypeEnum(String prefix, String desc){
        this.prefix=prefix;
    }
}
