import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Choose\n" +
                "A. Celsius to Fahrenheit\n" +
                "B. Fahrenheit to Celsius");
        String choice = scanner.nextLine();

        switch(choice.toUpperCase()) {
            case "A":
                System.out.println("Enter Celsius");
                double celsius = scanner.nextDouble();
                System.out.printf("%.2f Celsius is %.2f Fahrenheit", celsius, (celsius * 9 / 5) + 32);
                break;
            case "B":
                System.out.println("Enter Fahrenheit");
                double fahrenheit = scanner.nextDouble();
                System.out.printf("%.2f Fahrenheit is %.2f Celsius", fahrenheit, (fahrenheit - 32) * 5 / 9);
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }
}
