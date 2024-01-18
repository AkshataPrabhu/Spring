package com.example.demo.components;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.logging.Logger;

@Component("coolbean")
public class MySingletonComponent {

    LocalTime time;
    public MySingletonComponent() {
        time =  LocalTime.now();

    }
    @Override
    public String toString() {
        return "MySingletonComponent {}"+time;
    }
}
