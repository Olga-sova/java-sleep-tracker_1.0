package ru.yandex.practicum.sleeptracker;

import java.util.List;

public class SleepStatistics {

    public double calculateQualityPercentage(List<SleepingSession> sessions) {
        if (sessions.isEmpty()) {
            return 0.0;
        }

        long goodSessionsCount = sessions.stream()
                .filter(session ->
                        session.getQuality() == SleepAnalyzer.SleepQuality.GOOD ||
                                session.getQuality() == SleepAnalyzer.SleepQuality.NORMAL
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

    public void printTotalSleepSessions(List<SleepingSession> sessions) {
        long totalSessions = sessions.size();
        System.out.println("Всего сессий сна: " + totalSessions);
    }

}
