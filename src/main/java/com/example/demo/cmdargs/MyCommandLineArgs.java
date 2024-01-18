package com.example.demo.cmdargs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class MyCommandLineArgs {
    Logger logger = Logger.getLogger(MyCommandLineArgs.class.getName());
    @Autowired
    ApplicationArguments args;

    @Autowired
    public MyCommandLineArgs(ApplicationArguments args) {
    //access args variable here
    }

    public void printArgs() {

        //pass this in the command line
        logger.info(args.getNonOptionArgs().toString());
        logger.info(args.getOptionNames().toString());
        for (String src: args.getSourceArgs()) {
            logger.info("src val " + src);
        }

        for (String src: args.getOptionNames()) {
            logger.info("key " + src + " value " + args.getOptionValues(src));
        }
        logger.info(args.getOptionNames().toString());

    }
}
