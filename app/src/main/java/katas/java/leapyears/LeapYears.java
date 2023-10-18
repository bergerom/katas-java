package katas.java.leapyears;

public class LeapYears {

    public static boolean isLeapYear(int i) {
        return !isDivisibleBy4000(i) && (isDivisibleBy400(i) || isDivisibleBy4AndNotBy100(i));
    }

    private static boolean isDivisibleBy400(int i) {
        return (i % 400 == 0);
    }

    private static boolean isDivisibleBy4AndNotBy100(int i) {
        return (i % 4 == 0 && i % 100 != 0);
    }

    private static boolean isDivisibleBy4000(int i) {
        return (i % 4000 == 0);
    }
}
