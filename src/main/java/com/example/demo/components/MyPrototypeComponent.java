package com.example.demo.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Scope("prototype")
public class MyPrototypeComponent {

    LocalTime time;
    public MyPrototypeComponent() {
         time =  LocalTime.now();

    }

    @Override
    public String toString() {
        return "MyPrototypeComponent {}"+time;
    }
}
