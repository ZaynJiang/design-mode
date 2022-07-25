package cn.zayn.design.mode.hotconfig;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleUpdate {
    private final ScheduledExecutorService executor;
    private long initialDelayInSeconds;
    private long periodInSeconds;
    private Updater updater;

    public ScheduleUpdate(Updater updater, long initialDelayInSeconds, long periodInSeconds) {
        this.executor = Executors.newSingleThreadScheduledExecutor();
        this.updater = updater;
        this.initialDelayInSeconds = initialDelayInSeconds;
        this.periodInSeconds = periodInSeconds;
    }

    public void run() {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                updater.update();
            }
        }, initialDelayInSeconds, periodInSeconds, TimeUnit.MINUTES);
    }
}
