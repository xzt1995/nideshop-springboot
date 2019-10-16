package com.newland.nideshopserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.newland.nideshopserver.mapper")
@ComponentScan(basePackages = "com.newland")
public class NideshopServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NideshopServerApplication.class, args);
    }

}
