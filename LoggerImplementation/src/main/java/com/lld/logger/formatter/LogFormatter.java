package com.lld.logger.formatter;

import com.lld.logger.core.LogEvent;

public interface LogFormatter {
    String format(LogEvent event);
}