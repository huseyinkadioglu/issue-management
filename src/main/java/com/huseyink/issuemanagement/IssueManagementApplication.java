package com.huseyink.issuemanagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IssueManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(IssueManagementApplication.class, args);
    }


    // springin ioc containerına koyuyoruz herkes erişip kullanabiliyor.
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }


}
