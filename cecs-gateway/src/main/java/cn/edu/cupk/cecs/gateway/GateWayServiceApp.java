package cn.edu.cupk.cecs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author  赵希奥
 * @date  ${DATE} ${TIME}
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description: 
 */

@SpringBootApplication
@EnableDiscoveryClient
public class GateWayServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(GateWayServiceApp.class, args);
    }
}