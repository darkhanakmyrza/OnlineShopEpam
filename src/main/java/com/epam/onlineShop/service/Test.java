package com.epam.onlineShop.service;



import org.apache.log4j.Level;

import org.apache.log4j.Logger;
import org.apache.log4j.Logger;

public class Test {
    private static final Logger LOGGER = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        LOGGER.trace("This is a TRACE message");

        LOGGER.debug("This is a DEBUG message");

        LOGGER.info("This is an INFO message");

        LOGGER.warn("This is a WARN message");

        LOGGER.error("This is an ERROR message");

        LOGGER.fatal("This is a FATAL message");



    }
}
