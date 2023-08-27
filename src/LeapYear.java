public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year < 1 || year > 9999) {
            return false;
        } else if (year % 4 == 0) {
        } else if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true; // Divisible by 400
                }
                return false; // Divisible by 100 but not 400
            }
            return true; // Divisible by 4
        } else {
            return false; // Not divisible by 4
        }
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600)); // false
        System.out.println(isLeapYear(1600));  // true
        System.out.println(isLeapYear(2017));  // false
        System.out.println(isLeapYear(2000));  // true
    }
}
