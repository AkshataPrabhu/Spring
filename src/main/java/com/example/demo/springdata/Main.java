package com.example.demo.springdata;


import com.example.demo.springdata.service.EmployeeService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo")
public class Main {
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        System.setProperty("spring.config.name","springData");
        ApplicationContext ctx = run(com.example.demo.MainPackage.DemoApplication.class, args);
        EmployeeService service = ctx.getBean(EmployeeService.class);
        service.insertEmployee("Python", 10, 17);
        service.modifyEmployee(2, 1);

    }


}


