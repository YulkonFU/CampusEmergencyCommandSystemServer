package cn.edu.cupk.panel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 赵希奥
 * @date ${DATE} ${TIME}
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.edu.cupk.event.api"})
public class PanelApp {
    public static void main(String[] args) {
        SpringApplication.run(PanelApp.class, args);
    }
}