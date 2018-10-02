package com.fuseworks.labs.playground.sandbox;

import org.junit.Test;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class TimeTest {


    @Test
    public void testingTime() {
        OffsetDateTime offsetDatetimeNow = OffsetDateTime.now();
        System.out.println("offsetDatetimeNow = " + offsetDatetimeNow);

        ZonedDateTime zonedDateTimeNow = offsetDatetimeNow.toZonedDateTime();
        System.out.println("zonedDateTimeNow = " + zonedDateTimeNow);

        Date dateNow = new Date(offsetDatetimeNow.toInstant().toEpochMilli());
        System.out.println("dateNow = " + dateNow);

        Date offsetDateTimeNowUTC = new Date(OffsetDateTime
                .now()
                .atZoneSameInstant(ZoneOffset.UTC).toInstant().toEpochMilli());
        System.out.println("offsetDateTimeNowUTC = " + offsetDateTimeNowUTC);

        Long dateTimeLong = new Date().getTime();
        System.out.println("dateTimeLong = " + dateTimeLong);

        Long ZonedDateTimeLong = OffsetDateTime
                .now()
                .atZoneSameInstant(ZoneOffset.UTC)
                .toInstant()
                .toEpochMilli();

        System.out.println("ZonedDateTimeLong = " + ZonedDateTimeLong);

        Date computedDate = new Date(dateTimeLong);
        System.out.println("computedDate = " + computedDate);

        Date computedDate2 = new Date(ZonedDateTimeLong);
        System.out.println("computedDate2 = " + computedDate2);

        OffsetDateTime tz = OffsetDateTime.now().atZoneSameInstant(ZoneOffset.UTC).toOffsetDateTime();


        System.out.println(tz);
    }
}