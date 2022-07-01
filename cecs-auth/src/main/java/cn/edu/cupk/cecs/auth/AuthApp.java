package cn.edu.cupk.cecs.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 赵希奥
 * @date 2022/6/27 10:22
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxaz
 * @description:
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.edu.cupk.admin.api"})
public class AuthApp {

    public static void main(String[] args) {
        SpringApplication.run(AuthApp.class, args);
    }

}
