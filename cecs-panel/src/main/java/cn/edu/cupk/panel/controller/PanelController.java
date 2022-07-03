package cn.edu.cupk.panel.controller;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 赵希奥
 * @date 2022/7/2 23:03
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@RestController
@RequestMapping("/panel")
@EnableFeignClients(basePackages = {"cn.edu.cupk.event.api"})
public class PanelController {



}
