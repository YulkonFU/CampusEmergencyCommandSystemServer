package cn.edu.cupk.cecs.watchkeeper;

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
public class WatchKeeperApp {
    public static void main(String[] args) {
        SpringApplication.run(WatchKeeperApp.class,args);
    }
}