package employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        float salary;

        System.out.print("Enter Employee Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Employee Salary: ");
        salary = scanner.nextFloat();

        Employee employee = new Employee(name,salary);
        employee.displayTotalDeductionAndTakeHomePay();
    }
}
