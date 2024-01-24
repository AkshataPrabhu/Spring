package com.example.demo.MainPackage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @RequestMapping("/greetings")
    public String printgreeting(){
        return "hello from the other side";

    }


}
