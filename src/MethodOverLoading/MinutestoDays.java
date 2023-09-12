package MethodOverLoading;

public class MinutestoDays {
    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else {
            long years = minutes / (60 * 24 * 365); // Calculate years
            long remainingMinutes = minutes % (60 * 24 * 365); // Calculate remaining minutes
            long days = remainingMinutes / (60 * 24); // Calculate days

            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
    }
}
