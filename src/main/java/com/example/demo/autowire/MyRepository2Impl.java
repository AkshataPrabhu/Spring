package com.example.demo.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("MyRepository2Impl")
public class MyRepository2Impl implements MyRepository {
    @Value("20.0")
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
