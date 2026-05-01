package ru.yandex.practicum.sleeptracker;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class SleepDataSaver {
    public static void saveSleepSessions(List<SleepingSession> sessions, String filePath) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(sessions);
            System.out.println("Данные успешно сохранены в " + filePath);
        }
    }
}

