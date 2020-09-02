package com.kv.concurrency.dt;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConversion {

  public static void main(String[] args) {

    String dt = "03/13/1980 02:30:30 PM";

    ZonedDateTime est = ZonedDateTime.parse(dt, DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a").withZone(ZoneId.of("EST", ZoneId.SHORT_IDS)));
    System.out.println(est.toLocalDate());
    System.out.println(est.toLocalDateTime());
    System.out.println(est.toOffsetDateTime());
    System.out.println("----------------------");
    System.out.println(LocalDateTime.now());
    System.out.println(ZonedDateTime.now());
    System.out.println("----------------------");
    System.out.println(Instant.now());
    System.out.println(OffsetDateTime.now(Clock.systemUTC()));


  }

}
