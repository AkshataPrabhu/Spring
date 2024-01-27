package com.example.demo.rest;


import com.example.demo.crudRepository.service.EmployeeServiceCR;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo.rest")
public class RestMain {
    static Logger logger = Logger.getLogger(RestMain.class.getName());
    public static void main(String[] args) {

        System.setProperty("spring.config.name","springData");
        ApplicationContext ctx = run(com.example.demo.MainPackage.DemoApplication.class, args);

    }


}


