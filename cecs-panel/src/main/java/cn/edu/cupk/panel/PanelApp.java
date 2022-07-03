package cn.edu.cupk.panel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 赵希奥
 * @date ${DATE} ${TIME}
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PanelApp {
    public static void main(String[] args) {
        SpringApplication.run(PanelApp.class, args);
    }
}