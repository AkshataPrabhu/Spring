package com.example.demo.crudRepository.service;

import com.example.demo.crudRepository.model.EmployeeModelCR;
import com.example.demo.crudRepository.repository.EmployeeRepositoryCR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
public class EmployeeServiceCR {
    @Autowired
    EmployeeRepositoryCR repo;
    Logger logger = Logger.getLogger(EmployeeServiceCR.class.getName());

    public void insertEmployee(String name, int age, int salary) {
        EmployeeModelCR e = new EmployeeModelCR(-1, name, age, salary);
        repo.save(e);
        logger.info("New Record inserted. Number of employees " + repo.count());
    }

    public void modifyEmployee(int updateEmpId,int deleteEmpId ){
        logger.info("old update record of employee  "+repo.findById(updateEmpId).get());
        EmployeeModelCR e = repo.findById(updateEmpId).get();
        e.setSambol(80000);
        repo.save(e);
        logger.info("new update record of employee  "+repo.findById(updateEmpId).get());
        repo.deleteById(deleteEmpId);
        logger.info("Deleted employee record "+ deleteEmpId);
        logger.info("number of employees "+ repo.count());
        logger.info("All employees "+ repo.findAll());
    }

    public void customeQueries() {
        logger.info("Print emps in the salary range of [2000,10000]");
        List<EmployeeModelCR> emps = repo.findbyRange(200,1000000);
        for(EmployeeModelCR i : emps){
            logger.info(
                    "employee : " + i);
        }

        logger.info("find by name python");
        for(EmployeeModelCR e : repo.findAll()){
            logger.info("E :" + e);
        }
        EmployeeModelCR e = repo.findByName("Python");
        logger.info("employee record "+ e);

        Pageable p = PageRequest.of(2, 2, Sort.Direction.ASC, "sambol");
        List<EmployeeModelCR> empsInRange = repo.findbyRangePageable(200, 100000, p);
        logger.info("Employees in tha range: in page 2:"+ empsInRange);

    }

}
