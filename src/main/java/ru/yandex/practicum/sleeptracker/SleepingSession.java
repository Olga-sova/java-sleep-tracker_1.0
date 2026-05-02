package ru.yandex.practicum.sleeptracker;

public class SleepingSession {
    private String date; // Дата сна
    private int startTime; // Время начала сна (например, в минутах от начала суток)
    private int endTime; // Время окончания сна
    private boolean isRestful; // Флаг, указывающий на качество сна, для фильтрации сна по качеству пригодится

    public SleepingSession(String date, int startTime, int endTime, boolean isRestful) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isRestful = isRestful;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public boolean isRestful() {//для фильтрации сна по качеству пригодится
        return isRestful;
    }

    public void setRestful(boolean restful) {
        isRestful = restful;
    }

    @Override
    public String toString() {
        return "Сессия сна: " +
                "дата '" + date + '\'' +
                ", засыпание: " + startTime +
                ", пробуждение: " + endTime +
                ", isRestful=" + isRestful +//на сколько качественный был сон
                '}';
    }

    // Дополнительный метод — расчёт продолжительности сна в минутах
    public int getDuration() {
        return endTime - startTime;
    }
}
