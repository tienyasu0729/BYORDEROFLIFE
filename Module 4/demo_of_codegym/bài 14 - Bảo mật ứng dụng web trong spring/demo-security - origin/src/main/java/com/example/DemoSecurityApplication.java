package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityApplication.class, args);
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println("---------password---------------");
//        System.out.println(encoder.encode("12345"));
    }

}
