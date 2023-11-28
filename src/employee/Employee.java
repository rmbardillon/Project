package employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Employee {
    private static final float PAGIBIG_RATE_1 = 0.01f;
    private static final float PAGIBIG_RATE_2 = 0.02f;
    private static final float PAGIBIG_RATE_DEFAULT = 100.0f;
    private static final String CSV_FILE_PATH = "src/employee/sss-contribution.csv";
    String name;
    float salary;

    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }

    public float getSSSContributionRange() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            boolean firstRow = true;
            while ((line = reader.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                    continue;
                }
                String[] values = line.split(",");
                float lowerLimit = Float.parseFloat(values[0]);
                float upperLimit = Float.parseFloat(values[1]);
                float totalContribution = Float.parseFloat(values[2]);
                if(lowerLimit <= salary && upperLimit >= salary) {
                    return totalContribution;
                } else if (salary > Float.MAX_VALUE){
                    return 1350;
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the CSV file: " + e.getMessage());
            return 0.0f;
        } catch (NumberFormatException e) {
            System.err.println("Error parsing data in CSV file: " + e.getMessage());
            return 0.0f;
        }
        return 0.0f;
    }

    public float getPagIbigContribution() {
        if (salary <= 1500) {
            return salary * PAGIBIG_RATE_1;
        } else if (salary <= 5000) {
            return salary * PAGIBIG_RATE_2;
        } else {
            return PAGIBIG_RATE_DEFAULT;
        }
    }

    public float getPhilHealthContribution() {
        if(salary < 10000) {
            return 225;
        } else if(salary <= 90000) {
            return (float) (salary *.045) / 2;
        } else {
            return 4050;
        }
    }

    public float getTaxableIncome(float totalContribution) {
        return salary - totalContribution;
    }

    public float getIncomeTax(float taxableIncome) {
        if(salary <= 20833) {
            return 0;
        } else if(salary <= 33332) {
            return (float) ((taxableIncome - 20833) * .2);
        } else if(salary <= 66666) {
            return (float) (2500 + ((taxableIncome - 33333) * .25));
        } else if(salary <= 166666) {
            return (float) (10833.33 + ((taxableIncome - 66667) * .30));
        } else if(salary <= 666666) {
            return (float) (40833.33 + ((taxableIncome - 166667) * .32));
        } else {
            return (float) (200833.33 + ((taxableIncome - 666667) * .35));
        }
    }

    public void displayTotalDeductionAndTakeHomePay() {
        DecimalFormat decimalFormat = new DecimalFormat("₱#,###.00");

        float sssContribution = getSSSContributionRange();
        float pagibigContribution = getPagIbigContribution();
        float philHealthContribution = getPhilHealthContribution();
        float totalContribution = sssContribution + pagibigContribution + philHealthContribution;
        float taxableIncome = getTaxableIncome(totalContribution);
        float incomeTax = getIncomeTax(taxableIncome);
        float takeHomePay = salary - totalContribution - incomeTax;

        System.out.printf("Employee Name: %s\n", name);
        System.out.printf("Salary: %s\n", decimalFormat.format(salary));
        System.out.printf("Total Contribution: %s\n", decimalFormat.format(totalContribution));
        System.out.printf("\t-SSS Contribution: %s\n", decimalFormat.format(sssContribution));
        System.out.printf("\t-Pag-Ibig Contribution: %s\n", decimalFormat.format(pagibigContribution));
        System.out.printf("\t-PhilHealth Contribution: %s\n", decimalFormat.format(philHealthContribution));
        System.out.printf("Income Tax: %s\n\n", decimalFormat.format(incomeTax));
        System.out.printf("Take Home Pay: %s\n", decimalFormat.format(takeHomePay));
    }
}
