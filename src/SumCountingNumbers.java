public class SumCountingNumbers {
    public static int sumCountingNumbers(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        int n = 300;
        System.out.println(sumCountingNumbers(n));
    }
}
