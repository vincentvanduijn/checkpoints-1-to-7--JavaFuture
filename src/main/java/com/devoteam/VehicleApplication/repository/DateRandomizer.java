package main.java.com.devoteam.VehicleApplication.repository;

import main.java.com.devoteam.VehicleApplication.domain.DateFormater;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DateRandomizer {

    public static String randomiseCreatedAt() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
                "MMM dd, yyyy, HH:mm:ss", Locale.ENGLISH);

        Random random = new Random();

        int randomAmountOfSeconds = random.nextInt(60);
        int randomAmountOfMinutes = random.nextInt(60);
        int randomAmountOfHours = random.nextInt(24);
        int randomAmountOfDays = random.nextInt(365);

        LocalDateTime futureLocalDateTime = DateFormater.localDateTime.minusSeconds(randomAmountOfSeconds).minusMinutes(randomAmountOfMinutes).
                minusHours(randomAmountOfHours).minusDays(randomAmountOfDays);


        return futureLocalDateTime.format(
                dateTimeFormatter);

    }
}
