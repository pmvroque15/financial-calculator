package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    static void main() {
        //Instantiate Scanner
        Scanner scanner = new Scanner(System.in);
        //Declare and Assign Variables
        double total = 0;
        double totalInterestPaid  = 0;
        //Prompt:Greeting
        System.out.println("Hello! Welcome to the Mortgage Calculator.");
        //Make a prompt that asks the first and last name of the client
        System.out.println("What is your first and last name? ");
        String userName = scanner.nextLine();
        //Make a prompt that asks the total amount of the loan/Principal (P)
        System.out.println("What is the total amount of the loan? ");
        double userPrincipalAmount = scanner.nextDouble();
        //Make a prompt that asks how much is the annual interest rate (r)
        System.out.println("How much is the annual interest rate? ");
        double userAnnualInterestRate = scanner.nextDouble();
        userAnnualInterestRate = percentToDecimal(userAnnualInterestRate);
        //Ask the user how much loan terms in years (y)
        System.out.println("How much loan terms in years? ");
        double userLoanTermYears = scanner.nextDouble();
        scanner.nextLine();
        //Monthly payment will be passing through a method and display it here
        double userMonthlyPayments = numberOfMonthlyPayments(userLoanTermYears);
        //A method that will be called to calculate monthly interest Rate (i)
        double userMonthlyInterestRate = monthlyInterestRate(userAnnualInterestRate);
        System.out.println(" "); // Separation between prompts and the breakdown
        //Full Calculation
        total += monthlyPaymentCalculator(
                userPrincipalAmount, userMonthlyPayments, userMonthlyInterestRate);
        totalInterestPaid += totalInterest(total, userMonthlyPayments, userPrincipalAmount);

        //Display Breakdown:
        System.out.printf("Hello, %s!\n", userName);
        System.out.print("-------------------------------------------\n");
        System.out.println(
                "Principal Amount: $" + (int)userPrincipalAmount + "\n"
                        + "Annual Interest Rate: " + (userAnnualInterestRate * 100) + "%\n"
                        + "Loan Term: " + (int)userLoanTermYears + " years\n"
                        + "Number of Monthly payments: " + (int)userMonthlyPayments + " months\n"
                        + "Monthly Interest Rate: " + userMonthlyInterestRate
        );
        //Displays Monthly payments and total interest paid
        System.out.printf("Your Monthly payment for %s years will be: $%.2f/month\n",
                            (int)userLoanTermYears, total);
        System.out.printf("Total Interest Paid: $%.2f", totalInterestPaid);
    }

    //Method that calculates Annual Interest Rate
        // from percentage to decimal (r)
    static double percentToDecimal(double annualInterestRate) {
        return annualInterestRate / 100;
    }
    //create a method that converts monthly payments (n)
        //12 * y
    static double numberOfMonthlyPayments(double loanTermInYears) {
        return (double) Math.round((12 * loanTermInYears) * 100) / 100;
    }
    //Monthly interest rate (i)
    static double monthlyInterestRate(double annualInterestRate) {
        return annualInterestRate / 12; //1 year = 12 months
    }
    //Calculates the monthly payment
        // M = P × (i * (1 + i)^n / ( (1 + i)^n ) - 1)
    static double monthlyPaymentCalculator(double principalAmount, double numberOfMonthlyPayments, double monthlyInterestRate ) {
        return principalAmount * ((monthlyInterestRate * (Math.pow((1 + monthlyInterestRate), numberOfMonthlyPayments)))/ ((Math.pow((1 + monthlyInterestRate), numberOfMonthlyPayments)) - 1));
    }
    //Create a method that calculates the annual interest rate
        //Total interest = (M * n) - P
    static double totalInterest(double totalMonthlyPayments, double numberOfMonthlyPayments, double principalAmount) {
        return (totalMonthlyPayments * numberOfMonthlyPayments) - principalAmount;
    }
}
