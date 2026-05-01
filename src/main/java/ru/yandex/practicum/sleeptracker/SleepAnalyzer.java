package ru.yandex.practicum.sleeptracker;

import java.util.List;


public class SleepAnalyzer {
    public enum SleepQuality {
        BAD, NORMAL, GOOD
    }

    public SleepQuality evaluateSession(SleepingSession session) {
        int duration = session.getDuration();

        if (duration < 6 * 60) {
            return SleepQuality.BAD;
        } else if (duration >= 8 * 60 && duration <= 10 * 60) {
            return SleepQuality.GOOD;
        } else {
            return SleepQuality.NORMAL;
        }
    }

    public double calculateQualityPercentage(List<SleepingSession> sessions) { //подсчёт true сессий в процентах
        if (sessions.isEmpty()) {
            return 0.0; // избегаем деления на ноль
        }

        long restfulCount = sessions.stream()
                .filter(SleepingSession::isRestful)
                .count();

        return (double) restfulCount / sessions.size() * 100;
    }

}
