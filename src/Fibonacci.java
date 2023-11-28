import java.util.Arrays;

public class Fibonacci {
    public int[] getFibonacci(int limit) {
        int[] result = new int[limit];

        int firstTerm = 0;
        int secondTerm = 1;

        result[0] = firstTerm;
        result[1] = secondTerm;
        for(int i = 2; i < limit; i++) {
            int sum = firstTerm + secondTerm;
            result[i] = sum;
            firstTerm = secondTerm;
            secondTerm = sum;
        }

        return result;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println(Arrays.toString(fibonacci.getFibonacci(10)));
    }
}
