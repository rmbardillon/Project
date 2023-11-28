public class PrimeNumber {
    public boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i=2; i<number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new PrimeNumber().isPrimeNumber(9));
    }
}
