package com.fanfanfan.yygh.hosp;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(value = "com.fanfanfan.yygh")
@MapperScan("com.fanfanfan.yygh.hosp.mapper")
@ComponentScan(value ="com.fanfanfan.yygh")
@EnableMongoRepositories(basePackages = {"com.fanfanfan.yygh.hosp.repository"})
public class ServiceHospMainSrarter {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospMainSrarter.class, args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
