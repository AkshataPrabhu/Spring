package com.example.demo.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MyServiceImpl implements MyService{

    MyRepository r;
    @Autowired

    public  MyServiceImpl(    @Qualifier("MyRepository3Impl") MyRepository r) {
        this.r = r;
        r.setDouble(100);
    }

    @Autowired
    public MyRepository repoP;
    @Autowired
    @Qualifier("MyRepository2Impl")
    public MyRepository repoNP;

    @Autowired
    public Collection<MyRepository> repos;
    @Override
    public double numberChangePrimary() {
        return repoP.addDouble(10);
    }
    @Override
    public double numberChangeNonPrimary() {
        return repoNP.addDouble(10);
    }

    @Override
    public double numberChangeContructor() {
        return r.addDouble(10);
    }

    @Override
    public String callAllRepo() {
    String result = "result ************* ";

        for(MyRepository r :repos) {
            result +=   "  " + r.addDouble(5)+ "  ";
        }
        return result;
    }
}
