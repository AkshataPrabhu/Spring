package com.example.demo.beanClasses;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    String var;

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public String toString() {
        return "MyConfigurationBean{" +
                "var='" + var + '\'' +
                '}';
    }

    @Bean(name="configbean")
    public MyConfigurationBean config1(){

        MyConfigurationBean c = new MyConfigurationBean();
        c.setVar("beanconfig1");
        return c;
    }
    @Bean
    public MyConfigurationBean config2(){

        MyConfigurationBean c = new MyConfigurationBean();
        c.setVar("beanconfig2");
        return c;
    }
}
