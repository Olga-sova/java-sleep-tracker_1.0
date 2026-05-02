package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;

public class SleepingSession {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private SleepAnalyzer.SleepQuality quality;

    public SleepingSession(LocalDateTime startTime, LocalDateTime endTime, SleepAnalyzer.SleepQuality quality) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.quality= quality;
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
    @Override
    public String toString() {
        return String.format("%s;%s;%s", startTime, endTime, quality);
    }
}
