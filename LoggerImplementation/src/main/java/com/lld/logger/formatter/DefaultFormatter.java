package com.lld.logger.formatter;

import com.lld.logger.core.LogEvent;

public class DefaultFormatter implements LogFormatter {
    @Override
    public String format(LogEvent event) {
        return "[%s] [%s] [%s]: %s".formatted(
            event.timestamp(), event.threadName(), event.logLevel(), event.message());
    }
}