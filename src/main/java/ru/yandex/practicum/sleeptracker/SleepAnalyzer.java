package ru.yandex.practicum.sleeptracker;

import java.util.Comparator;
import java.util.List;


public class SleepAnalyzer {
    public enum SleepQuality {
        BAD, NORMAL, GOOD
    }

    public SleepQuality evaluateSession(SleepingSession session) {
        long duration = session.getDuration().toMinutes();

        if (duration < 6 * 60) {
            return SleepQuality.BAD;
        } else if (duration >= 8 * 60 && duration <= 10 * 60) {
            return SleepQuality.GOOD;
        } else {
            return SleepQuality.NORMAL;
        }
    }

    public double calculateQualityPercentage(List<SleepingSession> sessions) {
        if (sessions.isEmpty()) {
            return 0.0;
        }

        long goodSessionsCount = sessions.stream()
                .filter(session ->
                        session.getQuality() == SleepQuality.GOOD ||
                                session.getQuality() == SleepQuality.NORMAL
                )
                .count();

        return (double) goodSessionsCount / sessions.size() * 100;
    }

        public double findAverageDuration(List<SleepingSession> sessions) {
            if (sessions.isEmpty()) {
                return 0.0;
            }

            long totalDuration = sessions.stream()
                    .mapToLong(session -> session.getDuration().toMinutes())
                    .sum();

            return (double) totalDuration / sessions.size();
        }

    public SleepingSession getWorstNight(List<SleepingSession> sessions) {
        if (sessions.isEmpty()) {
            throw new IllegalArgumentException("Список сессий сна пуст");
        }

        return sessions.stream()
                .min(Comparator.comparingLong(session -> session.getDuration().toMillis()))
                .orElse(null);
    }
}
