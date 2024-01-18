package com.example.demo.components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Lazy
public class MyLazyComponent {

    LocalTime time;
    public MyLazyComponent() {
        time =  LocalTime.now();

    }
    @Override
    public String toString() {
        return "MyLazyComponent {}"+time;
    }
}
