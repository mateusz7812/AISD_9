package com.company.Timers;

import javax.swing.*;
import java.time.Duration;
import java.util.function.Function;

public interface TimerInterface {
    void Start();
    Duration GetCurrentValue();
    Duration TimeOperation(Runnable runnable);
}
