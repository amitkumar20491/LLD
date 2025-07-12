package com.lld.logger;

import com.lld.logger.core.LogLevel;
import com.lld.logger.destination.ConsoleLogDestination;
import com.lld.logger.formatter.DefaultFormatter;
import com.lld.logger.impl.AsyncLogger;

import java.util.List;

public class LoggerDemo {
    public static void main(String[] args) {
        var logger = new AsyncLogger(LogLevel.INFO, List.of(new ConsoleLogDestination()), new DefaultFormatter());

        logger.log(LogLevel.INFO, "Hello World !");
        logger.log(LogLevel.DEBUG, "Debug, will skip if configured level is INFO");
        logger.shutdown();
    }
}