package cn.edu.cupk.plan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 赵希奥
 * @date 2022/7/3 21:07
 * @github https://github.com/CKXGZXA
 * @gitee https://gitee.com/ckxgzxa
 * @description:
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.edu.cupk.plan.mapper")
public class PlanApp {
    public static void main(String[] args) {
        SpringApplication.run(PlanApp.class, args);
    }
}
