package com.example.demo.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MyRepositoryImpl implements MyRepository {
    @Value("10.0")
     double d;
    @Override
    public double addDouble(double val) {
        return this.d+val;
    }

    @Override
    public void setDouble(double val) {
        this.d=val;
    }
}
