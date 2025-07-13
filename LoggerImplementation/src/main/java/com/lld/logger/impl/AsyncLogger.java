package com.lld.logger.impl;

import com.lld.logger.core.LogEvent;
import com.lld.logger.core.LogLevel;
import com.lld.logger.destination.LogDestination;
import com.lld.logger.formatter.LogFormatter;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AsyncLogger {
    private final LogLevel configuredLevel;
    private final List<LogDestination> destinations;
    private final LogFormatter logFormatter;
    private final BlockingQueue<LogEvent> queue = new LinkedBlockingQueue<>(10000);
    private final ExecutorService worker = Executors.newSingleThreadExecutor();
    private final AtomicBoolean running = new AtomicBoolean(true);

    public AsyncLogger(LogLevel configuredLevel, List<LogDestination> destinations, LogFormatter logFormatter) {
        this.configuredLevel = configuredLevel;
        this.destinations = destinations;
        this.logFormatter = logFormatter;
        startWorker();
    }

    private void startWorker() {
        worker.submit(() -> {
            while (running.get() || !queue.isEmpty()) {
                try {
                    LogEvent logEvent = queue.poll(500, TimeUnit.MILLISECONDS);
                    if (logEvent != null) {
                        String formatted = logFormatter.format(logEvent);
                        for (var dest : destinations) {
                            dest.write(formatted);
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    public void shutdown() {
        running.set(false);
        worker.shutdown();
    }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= configuredLevel.ordinal()) {
            queue.add(new LogEvent(level, message));
        }
    }
}