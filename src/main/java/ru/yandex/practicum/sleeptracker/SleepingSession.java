package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class SleepingSession {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private final SleepAnalyzer.SleepQuality quality;
    private final Duration duration;

    public SleepingSession(LocalDateTime startTime, LocalDateTime endTime, SleepAnalyzer.SleepQuality quality) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.quality= quality;
        this.duration = Duration.between(startTime, endTime);
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s;%s;%s", startTime.format(formatter), endTime.format(formatter), quality);
    }
}
