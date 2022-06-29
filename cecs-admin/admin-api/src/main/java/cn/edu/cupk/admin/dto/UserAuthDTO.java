package cn.edu.cupk.admin.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 赵希奥
 * @date 2022/6/29 7:01
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */
@Data
public class UserAuthDTO {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户角色编码集合 ["ROOT","ADMIN"]
     */
    private List<String> roles;

    private List<String> authorities;

}
