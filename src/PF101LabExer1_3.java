import java.util.Scanner;

public class PF101LabExer1_3 {
    static Scanner scanner = new Scanner(System.in);
    static int[] emptyIntArray;

    public static void main(String[] args) {
        inputArray();
        displayArray();
        System.out.printf("The Sum of All the Elements is: %d\n", sumArray());
        System.out.printf("The Average of the Elements is: %.2f\n", averageArray());
        System.out.printf("The Odd Number/s: %s\n", oddArray());
        System.out.printf("The Even Number/s: %s\n", evenArray());
        System.out.printf("The Number/s Divisible by Five: %s\n", divbyfiveArray());
        System.out.printf("The Highest Element: %d\n", highestArray());
        System.out.printf("The Lowest Element: %d\n", lowestArray());
    }

    public static void inputArray() {
        int size;

        System.out.print("Enter the size of the Array: ");
        size = scanner.nextInt();

        emptyIntArray = new int[size];

        System.out.printf("Enter the %d Elements: \n", size);

        for(int i = 0; i < size; i++) {
            System.out.printf("Index[%d]: ", i);
            emptyIntArray[i] = scanner.nextInt();
        }
    }

    public static void displayArray() {
        System.out.println("The elements of the Array are: ");
        for(int i = 0; i < emptyIntArray.length; i++) {
            System.out.printf("Index[%d]: %d\n", i, emptyIntArray[i]);
        }

        /*
        You can also do this.
        System.out.printf("The elements of the Array are: %s\n", Arrays.toString(emptyIntArray));
        * */
    }

    public static int sumArray() {
        int sum = 0;

        for(int i = 0; i < emptyIntArray.length; i++) {
            sum += emptyIntArray[i];
        }

        return sum;
    }

    public static double averageArray() {
        return (double) sumArray() / emptyIntArray.length;
    }

    public static String oddArray() {
        StringBuilder oddArray = new StringBuilder();
        for(int i = 0; i < emptyIntArray.length; i++) {
            if (emptyIntArray[i] % 2 != 0) {
                if (!oddArray.isEmpty()) {
                    oddArray.append("\t");
                }
                oddArray.append(emptyIntArray[i]);
            }
        }
        return oddArray.toString();
    }

    public static String evenArray() {
        StringBuilder evenArray = new StringBuilder();
        for(int i = 0; i < emptyIntArray.length; i++) {
            if (emptyIntArray[i] % 2 == 0) {
                if (!evenArray.isEmpty()) {
                    evenArray.append("\t");
                }
                evenArray.append(emptyIntArray[i]);
            }
        }
        return evenArray.toString();
    }

    public static String divbyfiveArray() {
        StringBuilder divbyfiveArray = new StringBuilder();
        for(int i = 0; i < emptyIntArray.length; i++) {
            if (emptyIntArray[i] % 5 == 0) {
                if (!divbyfiveArray.isEmpty()) {
                    divbyfiveArray.append("\t");
                }
                divbyfiveArray.append(emptyIntArray[i]);
            }
        }
        return divbyfiveArray.toString();
    }

    public static int highestArray() {
        int highest = emptyIntArray[0];

        for (int i = 1; i < emptyIntArray.length; i++) {
            if (emptyIntArray[i] > highest) {
                highest = emptyIntArray[i];
            }
        }

        return highest;
    }

    public static int lowestArray() {
        int lowest = emptyIntArray[0];

        for (int i = 1; i < emptyIntArray.length; i++) {
            if (emptyIntArray[i] < lowest) {
                lowest = emptyIntArray[i];
            }
        }

        return lowest;
    }

}
