package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;
import java.time.Duration;

public class SleepingSession {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private final SleepAnalyzer.SleepQuality quality;
    private Duration duration;

    public SleepingSession(LocalDateTime startTime, LocalDateTime endTime, SleepAnalyzer.SleepQuality quality) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.quality= quality;
        Duration duration = Duration.between(startTime, endTime);
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }


    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public SleepAnalyzer.SleepQuality getQuality(){
        return quality;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s", startTime, endTime, quality);
    }
}
