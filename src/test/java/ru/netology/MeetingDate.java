package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MeetingDate {
    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
