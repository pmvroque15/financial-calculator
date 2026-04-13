package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    static void main(String[] args) {
        //Instantiate Scanner
        Scanner scanner = new Scanner(System.in);
        //Prompt:Greeting
        System.out.println("Hello! Welcome to the Mortgage Calculator.");
        //Make a prompt that asks the first and last name of the client
        System.out.println("What is your first and last name? ");
        String userName = scanner.nextLine();
        //Make a prompt that asks the monthlyPayment amount of the loan/Principal (P)
        System.out.println("What is the total loan amount? ");
        double userPrincipalAmount = Double.parseDouble(scanner.nextLine());
        //Make a prompt that asks how much is the annual interest rate (r)
        System.out.println("How much is the annual interest rate? ");
        double userAnnualInterestRate = scanner.nextDouble();
        userAnnualInterestRate = percentToDecimal(userAnnualInterestRate);
        //Ask the user how much loan terms in years (y)
        System.out.println("How much loan terms in years? ");
        int userLoanTermYears = scanner.nextInt();
        scanner.nextLine();
        //Monthly payment will be passing through a method and display it here
        int userMonthlyPayments = numberOfMonthlyPayments(userLoanTermYears);
        //A method that will be called to calculate monthly interest Rate (i)
        double userMonthlyInterestRate = monthlyInterestRate(userAnnualInterestRate);
        System.out.println(" "); // Separation between prompts and the breakdown
        //Full Calculation
        double monthlyPayment = monthlyPaymentCalculator(
                userPrincipalAmount, userMonthlyPayments, userMonthlyInterestRate);
        double totalInterestPaid = totalInterest(monthlyPayment, userMonthlyPayments, userPrincipalAmount);

        //Display Breakdown:
        System.out.printf("Hello, %s!\n", userName);
        System.out.print("-------------------------------------------\n");
        System.out.printf("Principal Amount: $%.2f\n", userPrincipalAmount);
        System.out.println(
                        "Annual Interest Rate: " + (userAnnualInterestRate * 100) + "%\n"
                        + "Loan Term: " + (int)userLoanTermYears + " years\n"
                        + "Number of Monthly payments: " + (int)userMonthlyPayments + " months"
        );
        System.out.printf("Monthly Interest Rate: %.5f\n", userMonthlyInterestRate);
        //Displays Monthly payments and monthlyPayment interest paid
        System.out.printf("Your Monthly payment for %s years will be: $%.2f/month\n",
                            (int)userLoanTermYears, monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f", totalInterestPaid);
    }

    //Method that calculates Annual Interest Rate
        // from percentage to decimal (r)
    static double percentToDecimal(double annualInterestRate) {
        return annualInterestRate / 100;
    }
    //create a method that converts monthly payments (n)
        //12 * y
    static int numberOfMonthlyPayments(int loanTermInYears) {
        return 12 * loanTermInYears;
    }
    //Monthly interest rate (i)
    static double monthlyInterestRate(double annualInterestRate) {
        return annualInterestRate / 12; //1 year = 12 months
    }
    //Calculates the monthly payment
        // M = P × (i * (1 + i)^n / ( (1 + i)^n ) - 1)
    static double monthlyPaymentCalculator(double principalAmount, double numberOfMonthlyPayments, double monthlyInterestRate ) {
        double factor = Math.pow((1 + monthlyInterestRate), numberOfMonthlyPayments);
        return principalAmount * (monthlyInterestRate * (factor / (factor - 1)));
    }
    //Create a method that calculates the annual interest rate
        //Total interest = (M * n) - P
    static double totalInterest(double monthlyPayments, double numberOfPayments, double principal) {
        return (monthlyPayments * numberOfPayments) - principal;
    }
}
