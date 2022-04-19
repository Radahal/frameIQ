package com.rgosiewski.frameiq.server.common.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class DateConverter {
    private static final String DEFAULT_DATE_TIME_FORMAT ="yyyy-MM-dd HH:mm:ss";
    private static final String SIMPLE_DATE_FORMAT ="dd.MM.yyyy";
    private static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);
    private static final DateTimeFormatter SIMPLE_DATE_FORMATTER = DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT);

    private DateConverter() {
        throw new IllegalStateException("Instantiation not allowed");
    }

    public static LocalDate toLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static Date toDateAtStartOfDay(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static Date toDateAtEndOfDay(LocalDate localDate) {
        return Date.from(LocalDateTime.of(localDate, LocalTime.MAX)
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public static LocalDate toLocalDate(String dateTime) {
        return toLocalDateTime(dateTime, DEFAULT_DATE_TIME_FORMAT).toLocalDate();
    }

    public static LocalDate toLocalDateSimple(String dateTime) {
        return toLocalDateTime(dateTime, SIMPLE_DATE_FORMAT).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(String dateTime) {
        return toLocalDateTime(dateTime, DEFAULT_DATE_TIME_FORMAT);
    }

    public static LocalDateTime toLocalDateTimeSimple(String dateTime) {
        return toLocalDateTime(dateTime, SIMPLE_DATE_FORMAT);
    }

    public static LocalDateTime toLocalDateTime(String dateTime, String format) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(format));
    }

    public static String toStartDayString(LocalDate localDate) {
        return localDate.atStartOfDay().format(DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT));
    }

    public static String toStartDayStringSimple(LocalDate localDate) {
        return localDate.atStartOfDay().format(DateTimeFormatter.ofPattern(SIMPLE_DATE_FORMAT));
    }

    public static Date toDateAtStartOfDay(String dateTime) {
        return toDateAtStartOfDay(LocalDate.parse(dateTime, DEFAULT_DATE_FORMATTER));
    }

    public static Date toDateAtStartOfDaySimple(String dateTime) {
        return toDateAtStartOfDay(LocalDate.parse(dateTime, SIMPLE_DATE_FORMATTER));
    }
}
