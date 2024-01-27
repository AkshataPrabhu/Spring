package com.example.demo.crudRepository;


import com.example.demo.crudRepository.service.EmployeeServiceCR;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@EntityScan(basePackages = "com.example.demo")
public class MainCrudRepo {
    static Logger logger = Logger.getLogger(MainCrudRepo.class.getName());
    public static void main(String[] args) {

        System.setProperty("spring.config.name","springData");
        ApplicationContext ctx = run(com.example.demo.MainPackage.DemoApplication.class, args);
        EmployeeServiceCR service = ctx.getBean(EmployeeServiceCR.class);
        service.insertEmployee("Python", 10, 17);

        service.modifyEmployee(2, 1);
        service.customeQueries();
    }


}


