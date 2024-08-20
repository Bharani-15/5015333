package com.example.BookstoreAPI.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Counter;
import org.springframework.stereotype.Component;

@Component
public class BookMetrics {

    private final Counter bookCreatedCounter;

    public BookMetrics(MeterRegistry meterRegistry) {
        this.bookCreatedCounter = meterRegistry.counter("book_created_total", Tags.of("status", "created"));
    }

    public void incrementBookCreated() {
        bookCreatedCounter.increment();
    }
}

