package com.example.demo.beanClasses;

public class NoBeanClass2 {
    NonBeanClass nbc;

    public NoBeanClass2(NonBeanClass nbc) {
        this.nbc = nbc;
    }

    public String concat() {
        return "concat in nobean2 using bean " + nbc.getVar1() + nbc.getVar2();
    }
}
