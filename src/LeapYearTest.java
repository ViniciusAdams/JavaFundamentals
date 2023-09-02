import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Import the LeapYear class without specifying a package
import LeapYear;

public class LeapYearTest {

    @Test
    public void testLeapYear() {
        // Test some known leap years
        assertTrue(LeapYear.isLeapYear(2000));
        assertTrue(LeapYear.isLeapYear(1600));
        assertTrue(LeapYear.isLeapYear(2400));

        // Test non-leap years
        assertFalse(LeapYear.isLeapYear(1900));
        assertFalse(LeapYear.isLeapYear(1700));
        assertFalse(LeapYear.isLeapYear(1800));
        assertFalse(LeapYear.isLeapYear(2100));

        // Test some random years
        assertTrue(LeapYear.isLeapYear(2024));
        assertFalse(LeapYear.isLeapYear(2021));
    }

    @Test
    public void testOutOfRange() {
        // Test years outside the valid range
        assertFalse(LeapYear.isLeapYear(-1600));
        assertFalse(LeapYear.isLeapYear(10000));
    }
}
