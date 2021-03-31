package datetimeapi;

import java.time.*;
import java.util.Date;

// TODO: 31.03.2021 14.1
public class Main {

    public static void main(String[] args) {

        // TODO: 31.03.2021 Period+LocalDate 
        Period periodDays = Period.ofDays(10);
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusDays(periodDays.getDays());
        localDate = localDate.plus(periodDays);
        periodDays = periodDays.withDays(20);
        localDate = localDate.minus(periodDays);
        localDate = localDate.withYear(2025);
        System.out.println(localDate);

        // TODO: 31.03.2021 Duration+LocalTime
        Duration durationHours = Duration.ofHours(5);
        LocalTime localTime = LocalTime.now();
        localTime = localTime.plus(durationHours);
        localTime = localTime.minusHours(durationHours.toHours());
        localTime = localTime.withMinute(40);
        System.out.println(localTime);

        // TODO: 31.03.2021 LocalDateTime+Period+Duration
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.minusDays(periodDays.getDays());
        durationHours = Duration.ofHours(1);
        localDateTime = localDateTime.minusHours(durationHours.toHours());
        System.out.println(localDateTime);


        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("UTC+3"));

        System.out.println(zonedDateTime);
        System.out.println(ZoneId.getAvailableZoneIds());

        // TODO: 31.03.2021 Instant
        Date date = new Date();
        Instant instantDate = date.toInstant();
        localDateTime = LocalDateTime.ofInstant(instantDate, ZoneId.systemDefault());
        localDateTime = instantDate.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);

        System.out.println(getLocalTime(new Date()));

    }

    static LocalTime getLocalTime(Date date) {
        Instant instantTime = date.toInstant();
        LocalTime localTime = instantTime.atZone(ZoneId.systemDefault()).toLocalTime();
        return localTime;

//        return LocalTime.ofInstant(date.toInstant(),ZoneId.systemDefault());
//        return (date.toInstant()).atZone(ZoneId.systemDefault()).toLocalTime();
    }


}
