public class Factorial {
    public int factorial(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorial(5));
    }
}
