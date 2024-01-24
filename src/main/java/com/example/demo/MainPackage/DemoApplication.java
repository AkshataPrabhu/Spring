package com.example.demo.MainPackage;

import com.example.demo.autowire.MyService;
import com.example.demo.beanClasses.MyConfigurationBean;
import com.example.demo.beanClasses.NonBeanClass;
import com.example.demo.cmdargs.MyCommandLineArgs;
import com.example.demo.components.MyLazyComponent;
import com.example.demo.components.MyPrototypeComponent;
import com.example.demo.components.MySingletonComponent;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.logging.Logger;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = run(DemoApplication.class, args);
        System.out.println(Arrays.asList(ctx.getBeanDefinitionNames()));
        beanConfiguation(ctx);

    }

    @Bean
    public MyConfigurationBean config3(){

        MyConfigurationBean c = new MyConfigurationBean();
        c.setVar("beanconfig3");
        return c;
    }
    private static void beanConfiguation(ApplicationContext ctx) {


        Logger logger = Logger.getLogger(DemoApplication.class.getName());
        MyConfigurationBean bean = ctx.getBean("configbean", MyConfigurationBean.class);
        MyConfigurationBean bean2 = ctx.getBean("config2", MyConfigurationBean.class);

        MyConfigurationBean bean3 = ctx.getBean("config3", MyConfigurationBean.class);
        logger.info("Bean1 of class myconfiguration bean "+ bean);
        logger.info("Bean2 of class myconfiguration bean " + bean2);
        logger.info("Bean3 of class demoapplication bean " + bean3);

        NonBeanClass b1 = ctx.getBean("createBean", NonBeanClass.class);
        logger.info("bean1 "+ b1);
        NonBeanClass b2 = ctx.getBean("create", NonBeanClass.class);
        logger.info("bean "+ b2);
        NonBeanClass b3 = ctx.getBean("create", NonBeanClass.class);
        logger.info("bean3 "+ b3);

    }

    private static void cmdLineArgsTest(ApplicationContext ctx) {
        MyCommandLineArgs cmdlineargs = ctx.getBean(MyCommandLineArgs.class);
        cmdlineargs.printArgs();
    }

    public static void autoWireTest(ApplicationContext ctx) {
        MyService service = ctx.getBean(MyService.class);
        Logger logger = Logger.getLogger(DemoApplication.class.getName());
        logger.info("After change of value via service " + service.numberChangePrimary());
        logger.info("After change of value via service in non primary " + service.numberChangeNonPrimary());
        logger.info("After change of value via service in autowired constructor " + service.numberChangeContructor());
        logger.info("working for multipls repos collection autwired " + service.callAllRepo());


    }

    public static void testScope(ApplicationContext ctx) throws InterruptedException {
        MySingletonComponent bean = ctx.getBean(MySingletonComponent.class);

        Logger logger = Logger.getLogger(DemoApplication.class.getName());
        logger.info("singleton class 1 " + bean);
        Thread.sleep(10);
        MySingletonComponent bean2 = ctx.getBean(MySingletonComponent.class);
        logger.info("singleton class 2 " + bean2);
        Thread.sleep(10);
        MySingletonComponent bean3 = ctx.getBean(MySingletonComponent.class);
        logger.info("singleton class 3" + bean3);
        Thread.sleep(10);

        MyPrototypeComponent pc = ctx.getBean(MyPrototypeComponent.class);
        logger.info(" prototype bea " + pc);
        Thread.sleep(10);
        MyPrototypeComponent pc2 = ctx.getBean(MyPrototypeComponent.class);
        logger.info(" prototype bea " + pc2);
        Thread.sleep(10);
        MyPrototypeComponent pc3 = ctx.getBean(MyPrototypeComponent.class);
        logger.info(" prototype bea " + pc3);
        MyLazyComponent lazy = ctx.getBean(MyLazyComponent.class);
        logger.info("lazy component obj " + lazy);


    }
}


