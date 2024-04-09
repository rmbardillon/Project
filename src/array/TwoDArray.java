package array;

import java.util.Scanner;

public class TwoDArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows, cols;
        String sort;

//        Ask the user for the size of the row and column
        System.out.println("What is the size of the row? ");
        rows = scanner.nextInt();
        System.out.println("What is the size of the column? ");
        cols = scanner.nextInt();

        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.printf("Value for row %d column %d: ", i+1, j+1);
                arr[i][j] = scanner.nextInt();
            }
        }

//        Ask user if they want to sort the array in ascending or descending order
        for(int row = 0; row < arr.length; row++) {
            System.out.printf("For row %d what sorting you like: ", row+1);
            do {
                System.out.println("Sorting\n A. Ascending\n D. Descending");
                sort = scanner.next();

                if(!sort.equalsIgnoreCase("A") && !sort.equalsIgnoreCase("D")) {
                    System.out.println("Invalid input!");
                }
            } while(!sort.equalsIgnoreCase("A") && !sort.equalsIgnoreCase("D"));

            switch (sort.toUpperCase()) {
                case "A":
                    System.out.println("Ascending");
                    sortAscendingOrder(arr[row]);
                    break;
                case "D":
                    System.out.println("Descending");
                    sortDescendingOrder(arr[row]);
                    break;
            }
        }

//        Display the row
        displaySortedArray(arr);
    }
//    Sort the array in ascending order
    public static void sortAscendingOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
//    Sort the array in descending order
    public static void sortDescendingOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
//    Display the sorted array
    public static void displaySortedArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Row %d: ", i+1);
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ",arr[i][j]);
            }
            System.out.println();
        }
    }
}
