import java.util.Scanner;

public class PF101LabExer1_2 {
    static Scanner scanner = new Scanner(System.in);
    static int positiveInteger;

    public static void main(String[] args) {
        System.out.printf("The Harmonic Sum is: %.2f\n", harmonicSum());
        System.out.printf("The Geometric Sum is: %.2f\n", geometricSum());
    }

    public static double harmonicSum() {
        double sum = 0.0;

        System.out.print("Enter a positive Integer: ");
        positiveInteger = scanner.nextInt();

        for (int i = 1; i <= positiveInteger; i++) {
            sum += (double) 1 /i;
        }
        return sum;
    }

    public static double geometricSum() {
        double sum = 0.0;

        System.out.print("Enter a positive Integer: ");
        positiveInteger = scanner.nextInt();

        for (int i = 0; i <= positiveInteger; i++) {
            sum += 1.0 / Math.pow(2, i);
        }
        return sum;
    }
}
