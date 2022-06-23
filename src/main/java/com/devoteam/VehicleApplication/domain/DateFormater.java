package main.java.com.devoteam.VehicleApplication.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateFormater {

    private static final String DATE_FORMATTER = "MMM dd, yyyy, HH:mm:ss";

    public static final LocalDateTime localDateTime = LocalDateTime.now();

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER, Locale.ENGLISH);
}
