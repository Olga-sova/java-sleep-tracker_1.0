package ru.yandex.practicum.sleeptracker;

import java.time.LocalTime;
import java.time.LocalDateTime;

public class NightSleepTracker {
    LocalTime nightStart = LocalTime.of(22, 0);
    LocalTime nightEnd = LocalTime.of(6, 0);

    public boolean isSessionDuringNight(SleepingSession session) {
        LocalDateTime startTime = session.getStartTime();
        LocalDateTime endTime = session.getEndTime();

        return (startTime.toLocalTime().isBefore(nightEnd) || startTime.toLocalTime().equals(nightEnd))
                && (endTime.toLocalTime().isAfter(nightStart) || endTime.toLocalTime().equals(nightStart));
    }
}
