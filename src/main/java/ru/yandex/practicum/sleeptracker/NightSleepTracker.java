package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class NightSleepTracker {
    LocalTime nightStart = LocalTime.of(22, 0);
    LocalTime nightEnd = LocalTime.of(6, 0);

    public boolean isSessionDuringNight(SleepingSession session) {
        LocalDateTime startTime = session.getStartTime();
        LocalDateTime endTime = session.getEndTime();

        return (startTime.toLocalTime().isBefore(nightEnd) || startTime.toLocalTime().equals(nightEnd))
                && (endTime.toLocalTime().isAfter(nightStart) || endTime.toLocalTime().equals(nightStart));
    }


    public static long countDaysInPeriod(LocalDate startDate, LocalDate endDate) {
        Period basePeriod = Period.between(startDate, endDate);

        return basePeriod.getDays() + 1;
    }

    public List<LocalDate> getSleeplessNights(LocalDate startDate, LocalDate endDate, List<SleepingSession> sessions) {

        long totalDays = countDaysInPeriod(startDate, endDate);

        return LongStream.range(0, totalDays)
                .mapToObj(startDate::plusDays)
                .filter(date -> sessions.stream()
                        .noneMatch(session -> isSessionDuringNight(session)
                                && session.getStartTime().toLocalDate().equals(date)))
                .collect(Collectors.toList());
    }
}

