package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    static void main() {
        //Instantiate Scanner
        Scanner scanner = new Scanner(System.in);
        //Declare and Assign Variables
        double total = 0;
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
        percentToDecimal(userAnnualInterestRate);
        System.out.println(percentToDecimal(userAnnualInterestRate));
        //Ask the user how much loan terms in years (y)
        System.out.println("How much loan terms in years? ");
        double userLoanTermYears = scanner.nextDouble();
        //Monthly payment will be passing through a method and display it here
        System.out.println("Number of monthly payments: " + "monthly payment answer here");
        //A method that will be called to calculate monthly interest Rate (i)
        System.out.println("Your Monthly Interest Rate: $" + "MIR here");
    }

    //Method that calculates Annual Interest Rate
        // from percentage to decimal (r)
    static double percentToDecimal(double annualInterestRate) {
        return annualInterestRate / 100;
    }
    //Create a method that calculates the monthly payment
        // M = P × (i * (1 + i)^n / ( (1 + i)^n ) - 1)
    //Create a method that calculates the annual interest rate
        //Total interest = (M * n) - P
    //Create a method that displays the expected monthly payment
    // and the total interest paid
    //Create a method that converts percent to double
    //create a method that converts monthly payments
        //12 * y

}
