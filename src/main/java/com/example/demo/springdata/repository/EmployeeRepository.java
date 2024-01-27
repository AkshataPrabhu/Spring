package com.example.demo.springdata.repository;

import com.example.demo.springdata.entitydata.EmployeeModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    public EntityManager entityManager;
    Logger logger = Logger.getLogger(EmployeeRepository.class.getName());

    public EmployeeModel getEmployee(int empId) {
        EmployeeModel em = null;
        try {
            //entityManager.clear();
            em = entityManager.find(EmployeeModel.class, empId);
        } catch (Exception ex) {
            logger.warning("Not found Employee with id " + empId);
        } finally {
            return em;
        }
    }


    @Transactional
    public void insert(EmployeeModel e) {
        entityManager.persist(e);
    }

    @Transactional
    public void updateEmployeeSalary(EmployeeModel e) {
        EmployeeModel old = entityManager.find(EmployeeModel.class, e.getEmpId());
        old.setAge(e.getAge());
        old.setName(e.getName());
        old.setSambol(e.getSambol());
    }

    public List<EmployeeModel> getAllEmployees() {
        String getAll = "Select e from EmployeeModel e";
        TypedQuery<EmployeeModel> query = entityManager.createQuery(getAll, EmployeeModel.class);
        return query.getResultList();
    }

    public long getEmployeeCount() {
        String countquery = "Select count(e) from EmployeeModel e";
        TypedQuery<Long> count = entityManager.createQuery(countquery, Long.class);
        return count.getSingleResult();
    }

    @Transactional
    public void deleteEmployees(int empId) {

        //add try catch
        EmployeeModel emp = entityManager.find(EmployeeModel.class, empId);
        entityManager.remove(emp);
    }
}
