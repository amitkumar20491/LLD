package com.lld.logger.core;

import java.time.LocalDateTime;

public record LogEvent(LogLevel logLevel, String message, LocalDateTime timestamp, String threadName) {
    public LogEvent(LogLevel logLevel, String message) {
        this(logLevel, message, LocalDateTime.now(), Thread.currentThread().getName());
    }
}