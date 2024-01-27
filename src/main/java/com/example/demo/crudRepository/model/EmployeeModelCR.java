package com.example.demo.crudRepository.model;


import jakarta.persistence.*;

import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Employee")
public class EmployeeModelCR {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    public int empId = -1;
    private String name;
    private int age;

    @Column(name = "salary")
    private int sambol;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSambol() {
        return sambol;
    }

    public void setSambol(int sambol) {
        this.sambol = sambol;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sambol=" + sambol +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeModelCR that = (EmployeeModelCR) o;
        return empId == that.empId && age == that.age &&
                sambol == that.sambol && Objects.equals(name, that.name);
    }

    public EmployeeModelCR() {

    }

    public EmployeeModelCR(int empId, String name, int age, int sambol) {
        this.empId = empId;
        this.name = name;
        this.age = age;
        this.sambol = sambol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name, age, sambol);
    }
}

