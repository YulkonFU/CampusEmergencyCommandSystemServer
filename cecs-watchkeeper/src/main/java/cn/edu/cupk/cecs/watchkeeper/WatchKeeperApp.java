package cn.edu.cupk.cecs.watchkeeper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with Intellij IDEA
 *
 * @Author:rst
 * @Date：${YEAR}/${MONTH}/${DAY}/${TIME}
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.edu.cupk.cecs.watchkeeper.mapper")
public class WatchKeeperApp {
    public static void main(String[] args) {
        SpringApplication.run(WatchKeeperApp.class,args);
    }
}