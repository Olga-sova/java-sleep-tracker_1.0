package ru.yandex.practicum.sleeptracker;

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
}
