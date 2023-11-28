public class GCD {
    public int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int num1 = 9;
        int num2 = 64;

        GCD gcd = new GCD();
        System.out.println(gcd.getGCD(num1, num2));
    }
}
