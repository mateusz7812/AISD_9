package com.company.Timers;

import javax.swing.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class Timer implements TimerInterface {
    LocalDateTime start;

    @Override
    public void Start() {
        start = LocalDateTime.now();
    }

    @Override
    public Duration GetCurrentValue() {
        var end = LocalDateTime.now();
        return Duration.between(start, end);
    }

    @Override
    public Duration TimeOperation(Runnable runnable) {
        Start();
        runnable.run();
        return GetCurrentValue();
    }
}
