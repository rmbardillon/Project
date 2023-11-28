public class LCM {
    public int getLCM(int num1, int num2) {
        GCD gcd = new GCD();
        int gcdResult = gcd.getGCD(num1, num2);

        return (num1 * num2) / gcdResult;
    }

    public static void main(String[] args) {
        int num1 = 9;
        int num2 = 64;

        LCM lcd = new LCM();
        System.out.println(lcd.getLCM(num1, num2));
    }
}
