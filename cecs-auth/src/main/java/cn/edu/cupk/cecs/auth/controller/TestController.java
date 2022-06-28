package cn.edu.cupk.cecs.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵希奥
 * @date 2022/6/27 11:07
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@RestController
public class TestController {
    @GetMapping("/hello")
    public String request() {
        return "hello";
    }

    @GetMapping("/nohello")
    public String nohello() {
        return "nohello";
    }

    @GetMapping("/canthello")
    @PreAuthorize("hasAuthority('canthello')")
    public String canthello() {
        return "canthello";
    }
}
