package grading_system;

import java.util.*;

public class GSystem {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int totalAttempts = 3;

        while (totalAttempts > 0) {
            System.out.println("Grading System Computation");
            System.out.println("\nType of Class");
            System.out.println("1 - Pure Lecture Class");
            System.out.println("2 - Lecture and Laboratory Class");

            int typeOfClass = getTypeOfClass();

            double[] prelimScores = getScores(typeOfClass, "Prelim");
            double prelimGrade = calculateGrade(typeOfClass, prelimScores);

            double[] midtermScores = getScores(typeOfClass, "Midterm");
            double midtermGrade = calculateGrade(typeOfClass, midtermScores);

            double[] finalsScores = getScores(typeOfClass, "Finals");
            double finalsGrade = calculateGrade(typeOfClass, finalsScores);

            double finalGrade = prelimGrade * 0.3 + midtermGrade * 0.3 + finalsGrade * 0.4;
            printGradesAndRemarks(prelimGrade, midtermGrade, finalsGrade, finalGrade);

            totalAttempts--;

            if (totalAttempts == 0) {
                System.out.println("You've reached the maximum number of attempts. Restarting the whole process.");
            } else {
                System.out.println("Do you want to compute grades for another student? (1 for Yes, 0 for No): ");
                int continueOption = input.nextInt();

                if (continueOption == 0) {
                    break;
                }
            }
        }
    }

    private static int getTypeOfClass() {
        int typeOfClass = 0;

        while (typeOfClass != 1 && typeOfClass != 2) {
            System.out.print("\nWhat type of class? ");
            try {
                if (input.hasNextInt()) {
                    typeOfClass = input.nextInt();
                } else {
                    handleInvalidInput();
                }
            } catch (InputMismatchException ex) {
                handleInvalidInput();
            }
            if (typeOfClass != 1 && typeOfClass != 2) {
                System.out.println("Please enter a valid class type.");
            }
        }

        return typeOfClass;
    }

    private static void handleInvalidInput() {
        System.out.println("Invalid input. Please enter 1 or 2.");
        input.next(); // Clear the invalid input
    }

    private static double[] getScores(int typeOfClass, String period) {
        System.out.println("\n" + period + " Period Components:");
        double[] scores = new double[6];
        String[] components = {"Quiz", "Participation", "Activity", "Examination", "Lab Quiz", "Lab Examination"};

        for (int i = 0; i < components.length; i++) {
            scores[i] = inputScore("Enter the " + period + " " + components[i] + ": ");
        }

        return scores;
    }

    private static double calculateGrade(int typeOfClass, double[] scores) {
        double lectureGrade = scores[0] * 0.20 + scores[1] * 0.10 + scores[2] * 0.20 + scores[3] * 0.50;
        if (typeOfClass == 2) {
            double labGrade = scores[4] * 0.40 + scores[5] * 0.60;
            return (lectureGrade * 0.60) + (labGrade * 0.40);
        }
        return lectureGrade;
    }

    private static double inputScore(String prompt) {
        int attempts = 3;
        double score = 0;

        while (attempts > 0) {
            System.out.print(prompt);
            try {
                score = input.nextDouble();
                if (score >= 0 && score <= 100 && !Double.isNaN(score)) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter a valid score between 0 and 100.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a valid numeric score.");
            } finally {
                input.nextLine(); // Clear the buffer
                attempts--;
            }

            if (attempts == 0) {
                System.out.println("You've reached the maximum number of attempts. Restarting the whole question.");
                break;
            }
        }

        return score;
    }

    private static void printGradesAndRemarks(double prelimGrade, double midtermGrade, double finalsGrade, double finalGrade) {
//        printGradeAndRemarks("Prelim", prelimGrade);
//        printGradeAndRemarks("Midterm", midtermGrade);
//        printGradeAndRemarks("Finals", finalsGrade);

        System.out.printf("\nFINAL GRADE: %.2f\n", finalGrade);
        System.out.println("Remarks: " + (finalGrade >= 75 ? "PASSED" : "FAILED"));
    }
}