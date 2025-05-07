package org.example.conference_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.example.conference_management.mapper"})
public class ConferenceManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConferenceManagementApplication.class, args);
    }
}
