package com.zjt.user_service9001;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableSwagger2
@MapperScan({"com.zjt.common.inter"})
@SpringBootApplication(scanBasePackages = {"com.zjt"})
public class UserService9001Application {

    public static void main(String[] args) { SpringApplication.run(UserService9001Application.class, args);

    }
}
