package com.example.demo.springdata.seed;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PopulateEmployee {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void populateEmployee(){
        jdbcTemplate.update("insert into employee(name,age,salary) values(?,?,?)", new Object[]{"aks",12,1123});
        jdbcTemplate.update("insert into employee(name,age,salary) values(?,?,?)", new Object[]{"aks2",13,1223});
        jdbcTemplate.update("insert into employee(name,age,salary) values(?,?,?)", new Object[]{"ak1",14,1233});
        jdbcTemplate.update("insert into employee(name,age,salary) values(?,?,?)", new Object[]{"aks3",25,1523});
        jdbcTemplate.update("insert into employee(name,age,salary) values(?,?,?)", new Object[]{"aks1",26,1623});
        jdbcTemplate.update("insert into employee(name,age,salary) values(?,?,?)", new Object[]{"ak2",27,1263});

    }
}
