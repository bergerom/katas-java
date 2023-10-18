package katas.java.leapyears;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeapYearsTest {
    @Test
    public void years_divisible_by_400_ARE_leap_years(){
        Assertions.assertTrue(LeapYears.isLeapYear(400));
        Assertions.assertTrue(LeapYears.isLeapYear(2000));
    }

    @Test
    public void years_divisible_by_4_but_not_by_100_ARE_leap_years(){
        Assertions.assertTrue(LeapYears.isLeapYear(2004));
        Assertions.assertTrue(LeapYears.isLeapYear(2008));
        Assertions.assertTrue(LeapYears.isLeapYear(20012));
    }

    @Test
    public void years_divisible_by_100_but_not_by_400_are_NOT_leap_years(){
        Assertions.assertFalse(LeapYears.isLeapYear(1900));
        Assertions.assertFalse(LeapYears.isLeapYear(2100));

    }

    @Test
    public void years_divisible_by_400_are_NOT_leap_years() {
        Assertions.assertFalse(LeapYears.isLeapYear(4000));
        Assertions.assertFalse(LeapYears.isLeapYear(8000));

    }
}
