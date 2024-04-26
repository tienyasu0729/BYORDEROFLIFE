package com.codegym.config;

import com.codegym.service.StudentService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public StudentService2 studentService2(){
        return new StudentService2();
    }
}
