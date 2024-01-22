package com.example.demo;

import com.example.demo.profileandproperties.Developmentimpl;
import com.example.demo.profileandproperties.ProfileInterface;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.logging.Logger;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class ProfilePropertiesMain {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active","development");
        System.setProperty("spring.config.name", "profilePropertiesyml");
        Logger logger = Logger.getLogger(ProfilePropertiesMain.class.getName());
        ApplicationContext ctx = run(ProfilePropertiesMain.class, args);
        //we can pass the active profile from command line as spring.profiles.active=development or in properties file - recommended way to send from cmd
        //testing with cmdline arg first then with system set property in java class
        //ProfileInterface profile = ctx.getBean(ProfileInterface.class);

        //logger.info(profile.printProfileInfo());

        System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));
        ProfileInterface profile = ctx.getBean(ProfileInterface.class);
        logger.info(profile.printProfileInfo());

    }

}


