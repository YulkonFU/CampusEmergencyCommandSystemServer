package cn.edu.cupk.supply;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("cn.edu.cupk.supply.mapper")
public class SupplyApp {
    public static void main(String[] args) {
        SpringApplication.run(SupplyApp.class, args);
    }
}