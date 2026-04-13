package com.pluralsight;

import java.util.Scanner;

public class FutureValue {
    static void main(String[] args) {
        // Instantiate scanner
        Scanner scanner = new Scanner(System.in);

        // It would accept the deposit, interest rate, and number of years from the user
        //Make a greeting prompt
        System.out.println("Hello! Welcome to the Future Value calculator");
        System.out.println("----------------------------------------------");
        //prompt asks the user's name
        System.out.println("Type your first and last name:");
        String userName = scanner.nextLine();
        //Asking for Principal (P): This is the initial deposit amount
        System.out.println("What is the initial deposit amount");
        double userPrincipalAmount = scanner.nextDouble();
        //Asking for Annual Interest Rate (r): The nominal annual interest rate in decimal form.
        System.out.println("Annual Interest Rate:");
        double userAnnualInterestRate = scanner.nextDouble();
        userAnnualInterestRate = percentToDecimal(userAnnualInterestRate);
        //Asking for Number of Years (t): The total number of years the deposit will earn interest.
        System.out.println("Enter how many years you plan to leave the money in the account: ");
        double userNumberOfYears = scanner.nextDouble();
        System.out.println(" ");
        //Days Per Year: Daily compounding assumes 365 days per year
            //Display Total Number of Days:
                // - This is 365 × t (because there are 365 days per year).
        System.out.printf("Hey %s!\n", userName);
        System.out.println("-------------------------");
        double userYearToDays = yearsToDays(userNumberOfYears);
        double futureValueTotal = futureValue(userPrincipalAmount, userAnnualInterestRate, userNumberOfYears);
        double userTotalInterestEarned = totalInterestEarned(futureValueTotal, userPrincipalAmount);
        // It would display the future value and the total interest earned
        System.out.printf("Future Value: $%.2f\n", futureValueTotal);
        System.out.printf("Total Interest Earned: $%.2f\n", userTotalInterestEarned);
        System.out.printf("Total Number of Days: %s days\n", (int)userYearToDays);

    }
    //Method that would calculate the Future Value
        // FV = P × (1 + (r / 365))^(365 × t)
    static double futureValue(double principal, double annualInterestRate, double numberOfYears) {
        double yearToDays = 365;
        double exponent = (yearToDays * numberOfYears);
        return (principal *
                Math.pow((1 + (annualInterestRate / yearToDays)), exponent));
    }

    static double percentToDecimal(double percent) {
        return (percent / 100);
    }
    //Method that converts years to days
        //365 × t
    static double yearsToDays(double numberOfYears) {
        return 365 * numberOfYears; // 1 year = 365 days
    }
    // Total Interest Earned = FV - P
    static double totalInterestEarned(double futureValue, double principal) {
        return futureValue - principal;
    }
}
