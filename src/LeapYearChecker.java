public class LeapYearChecker {
    public boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0) {
                return true;
            } else if (year % 400 == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new LeapYearChecker().isLeapYear(2000));
    }
}
