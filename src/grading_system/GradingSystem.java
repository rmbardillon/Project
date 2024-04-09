package grading_system;

import java.util.Scanner;

public class GradingSystem {
    static int quiz;
    static int laboratoryQuiz;
    static int participation;
    static int activity;
    static int examination;
    static int laboratoryExamination;
    static float prelimGrade;
    static float midtermGrade;
    static float finalsGrade;
    static Scanner scanner = new Scanner(System.in);

    public static int getTypeOfClass() {
        int typeOfClass;
        System.out.println("Grading System Computation\n");
        while (true) {
            try {
                System.out.print("Type Of Class\n" +
                        "1 - Pure Lecture Class\n" +
                        "2 - Lecture and Laboratory Class\n" +
                        "What type of class? ");
                typeOfClass = scanner.nextInt();

                if (typeOfClass == 1 || typeOfClass == 2) {
                    break;
                } else {
                    System.out.println("Invalid Input. Please Enter only 1 or 2");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                scanner.nextLine();
            }
        }

        return typeOfClass;
    }

    public static void inputPeriodComponents(String period, int typeOfClass) {
        System.out.printf("\n%s Period Components\n", period);
        if(typeOfClass == 1) {
            quiz = validateInputGrade(period, "Quiz");
            participation = validateInputGrade(period, "Participation");
            activity = validateInputGrade(period, "Activity");
            examination = validateInputGrade(period, "Examination");

            switch (period) {
                case "Prelim":
                        prelimGrade = (float) ((quiz * 0.2) + (participation * 0.1) + (activity * 0.2) + (examination * 0.5));
                        break;
                case "Midterm":
                        midtermGrade = (float) ((quiz * 0.2) + (participation * 0.1) + (activity * 0.2) + (examination * 0.5));
                        break;
                case "Finals":
                        finalsGrade = (float) ((quiz * 0.2) + (participation * 0.1) + (activity * 0.2) + (examination * 0.5));
                        break;
            }
        } else if(typeOfClass == 2) {
            System.out.println("Lecture Components");
            quiz = validateInputGrade(period, "Quiz");
            participation = validateInputGrade(period, "Participation");
            activity = validateInputGrade(period, "Activity");
            examination = validateInputGrade(period, "Written Periodical Examination");
            System.out.println("Laboratory Components");
            laboratoryQuiz = validateInputGrade(period, "Laboratory Quiz");
            laboratoryExamination = validateInputGrade(period, "Laboratory Examination");
            float lectureComponentGrade;
            float laboratoryComponentGrade;
            switch (period) {
                case "Prelim":
                    lectureComponentGrade = (float) ((quiz * 0.2) + (participation * 0.1) + (activity * 0.2) + (examination * 0.5));
                    laboratoryComponentGrade = (float) ((laboratoryQuiz * 0.4) + (laboratoryExamination * 0.6));
                    prelimGrade = (lectureComponentGrade * 0.6f) + (laboratoryComponentGrade * 0.4f);
                    break;
                case "Midterm":
                    lectureComponentGrade = (float) ((quiz * 0.2) + (participation * 0.1) + (activity * 0.2) + (examination * 0.5));
                    laboratoryComponentGrade = (float) ((laboratoryQuiz * 0.4) + (laboratoryExamination * 0.6));
                    midtermGrade = (lectureComponentGrade * 0.6f) + (laboratoryComponentGrade * 0.4f);
                    break;
                case "Finals":
                    lectureComponentGrade = (float) ((quiz * 0.2) + (participation * 0.1) + (activity * 0.2) + (examination * 0.5));
                    laboratoryComponentGrade = (float) ((laboratoryQuiz * 0.4) + (laboratoryExamination * 0.6));
                    finalsGrade = (lectureComponentGrade * 0.6f) + (laboratoryComponentGrade * 0.4f);
                    break;
            }
        }
    }

    public static int validateInputGrade(String period, String component) {
        int input;
        while(true) {
            try {
                System.out.printf("Enter the %s %s: ", period, component);
                input = scanner.nextInt();
                if (input >= 0 && input <= 100) {
                    break;
                } else {
                    System.out.println("Invalid Input. Please enter a valid score between 0 and 100.");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input. Please enter an integer.");
                scanner.nextLine();
            }
        }
        return input;
    }

    public static void displayGradesAndRemarks() {
        System.out.printf("\nPrelim Grade: %.2f\n", prelimGrade);
        System.out.println("Remarks: " + (prelimGrade >= 75 ? "Passed" : "Failed"));
        System.out.printf("\nMidterm Grade: %.2f\n", midtermGrade);
        System.out.println("Remarks: " + (midtermGrade >= 75 ? "Passed" : "Failed"));
        System.out.printf("\nFinals Grade: %.2f\n", finalsGrade);
        System.out.println("Remarks: " + (finalsGrade >= 75 ? "Passed" : "Failed"));
        float finalGrade = (prelimGrade * 0.3f) + (midtermGrade * 0.3f) + (finalsGrade * 0.4f);
        System.out.printf("\nFINAL GRADE: %.2f\n", finalGrade);
        System.out.println("Remarks: " + (finalGrade >= 75 ? "PASSED" : "FAILED"));
    }

    public static void main(String[] args) {
        String repeat;

        do {
            int choice = getTypeOfClass();

            inputPeriodComponents("Prelim", choice);
            inputPeriodComponents("Midterm", choice);
            inputPeriodComponents("Finals", choice);
            displayGradesAndRemarks();

            System.out.println("Do you want to input another student? (Y/N)");
            repeat = scanner.next();
            if (!repeat.equalsIgnoreCase("Y")) {
                break;
            }
        } while (repeat.equalsIgnoreCase("Y"));
    }
}