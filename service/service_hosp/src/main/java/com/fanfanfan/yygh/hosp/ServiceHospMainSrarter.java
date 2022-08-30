package com.fanfanfan.yygh.hosp;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.fanfanfan.yygh.hosp.mapper")
@ComponentScan(value ="com.fanfanfan.yygh")
public class ServiceHospMainSrarter {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospMainSrarter.class, args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}