package com.example.demo.springdata.service;

import com.example.demo.springdata.entitydata.EmployeeModel;
import com.example.demo.springdata.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repo;
    Logger logger = Logger.getLogger(EmployeeService.class.getName());

    public void insertEmployee(String name, int age, int salary) {
        EmployeeModel e = new EmployeeModel(-1, "java", 1, 1000);
        repo.insert(e);
        logger.info("New Record inserted. Number of employees " + repo.getEmployeeCount());
    }

    public void modifyEmployee(int updateEmpId,int deleteEmpId ){
        logger.info("old update record of employee  "+repo.getEmployee(updateEmpId).toString());
        EmployeeModel e = repo.getEmployee(updateEmpId);
        e.setSambol(8000);
        repo.updateEmployeeSalary(e);
        logger.info("new update record of employee  "+repo.getEmployee(updateEmpId).toString());

        repo.deleteEmployees(deleteEmpId);
        logger.info("Deleted employee record "+ deleteEmpId);
        logger.info("number of employees "+ repo.getEmployeeCount());
    }

}
