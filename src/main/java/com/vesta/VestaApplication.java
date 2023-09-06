package com.vesta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.vesta.*")
public class VestaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VestaApplication.class, args);
        System.out.println("vesta api启动成功");
    }

}
