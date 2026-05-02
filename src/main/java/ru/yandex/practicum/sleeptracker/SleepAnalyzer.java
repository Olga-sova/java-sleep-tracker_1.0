package ru.yandex.practicum.sleeptracker;

import java.util.Comparator;
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

   /*   этот код должен идти в main
    public String getSleepAdvice(List<SleepingSession> sessions) {
       double qualityPercentage = calculateQualityPercentage(sessions);

        if (qualityPercentage >= 80) {
            return "Отличный сон! Продолжайте в том же духе. Ваш процент качественного сна: " + qualityPercentage + " %";
        } else if (qualityPercentage >= 60) {
            return "Сон в норме, но есть потенциал для улучшения. Попробуйте:\n" +
                    "1. Соблюдать режим сна.\n" +
                    "2. Создать ритуалы перед сном.\n" +
                    "Ваш процент качественного сна: " + qualityPercentage + " %";
        } else if (qualityPercentage >= 40) {
            return "Качество сна ниже среднего. Рекомендуем:\n" +
                    "1. Ограничить использование гаджетов за час до сна.\n" +
                    "2. Избегать кофеина во второй половине дня.\n" +
                    "3. Обеспечить полную темноту и тишину в спальне.\n" +
                    "Процент качественного сна: " + qualityPercentage + " %";
        } else {
            return "Качество сна значительно ниже нормы. Срочно обратитесь к врачу и попробуйте:\n" +
                    "1. Соблюдать строгий режим сна и пробуждения.\n" +
                    "2. Создать максимально комфортные условия для сна.\n" +
                    "3. Избегать дневного сна.\n" +
                    "Процент качественного сна: " + qualityPercentage + " %";
    }
        }*/

        public double findAverageDuration(List<SleepingSession> sessions) {
            if (sessions.isEmpty()) {
                return 0.0;
            }

            long totalDuration = sessions.stream()
                    .mapToLong(SleepingSession::getDuration)
                    .sum();

            return (double) totalDuration / sessions.size();
        }

    public SleepingSession getWorstNight(List<SleepingSession> sessions) {
        if (sessions.isEmpty()) {
            throw new IllegalArgumentException("Список сессий сна пуст");
        }

        return sessions.stream()
                .min(Comparator.comparingLong(SleepingSession::getDuration))
                .orElse(null);
    }

}
