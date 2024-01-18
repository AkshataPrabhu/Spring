package com.example.demo.beanClasses;

import jakarta.annotation.ManagedBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
public class JustConfigurationClass {
     String a = "*";
    @Bean
    public NonBeanClass createBean(){
        NonBeanClass b = new NonBeanClass();
        b.setVar1("no bean");
        b.setVar2("2");
        return b;
    }
    //@Bean(name={"beans1, beans2, beans3"})
    @Bean(name = {"create","createn"})
    @Scope("prototype")
    public NonBeanClass createBeanold(){
        NonBeanClass b = new NonBeanClass();
        b.setVar1("customer create bean with different names");
        b.setVar2(this.a);
        this.a = this.a+ "*";
        return b;
    }
    @Bean
    public NoBeanClass2 create2(){
        NoBeanClass2 b = new NoBeanClass2(createBean());
        return b;

    }
    //beans are autowired here
    @Bean
    public NoBeanClass2 create3(@Qualifier("createBean") NonBeanClass nbc){
        NoBeanClass2 b = new NoBeanClass2(nbc);
        return b;

    }

}
