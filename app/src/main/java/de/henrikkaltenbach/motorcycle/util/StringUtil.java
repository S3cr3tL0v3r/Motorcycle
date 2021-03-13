package de.henrikkaltenbach.motorcycle.util;

import java.util.Locale;

public class StringUtil {

    public static String getNumber(int value) {
        return String.valueOf(value);
    }

    public static String getNumber(long value) {
        return String.valueOf(value);
    }

    public static String getNumber(float value) {
        return value != Float.MAX_VALUE ? String.valueOf(value) : "-";
    }

    public static String getNumber(double value) {
        return value != Double.MAX_VALUE ? String.valueOf(value) : "-";
    }

    public static String getZeroDecimal(float value) {
        return value != Float.MAX_VALUE && value != Float.MIN_VALUE ? String.format(Locale.US, "%.0f", value) : "-";
    }

    public static String getZeroDecimal(double value) {
        return value != Double.MAX_VALUE && value != Double.MIN_VALUE ? String.format(Locale.US, "%.0f", value) : "-";
    }

    public static String getOneDecimal(float value) {
        return value != Float.MAX_VALUE && value != Float.MIN_VALUE ? String.format(Locale.US, "%.1f", value) : "-";
    }

    public static String getOneDecimal(double value) {
        return value != Double.MAX_VALUE && value != Double.MIN_VALUE ? String.format(Locale.US, "%.1f", value) : "-";
    }

    public static String getTwoDecimal(float value) {
        return value != Float.MAX_VALUE && value != Float.MIN_VALUE ? String.format(Locale.US, "%.2f", value) : "-";
    }

    public static String getTwoDecimal(double value) {
        return value != Double.MAX_VALUE && value != Double.MIN_VALUE ? String.format(Locale.US, "%.2f", value) : "-";
    }

    public static String getSevenDecimal(float value) {
        return value != Float.MAX_VALUE && value != Float.MIN_VALUE ? String.format(Locale.US, "%.7f", value) : "-";
    }

    public static String getSevenDecimal(double value) {
        return value != Double.MAX_VALUE && value != Double.MIN_VALUE ? String.format(Locale.US, "%.7f", value) : "-";
    }

}
