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
        //Make a prompt that asks how much is the annual interest rate (r)
            //Annual Interest rate will be 0.07625 by default
        //Ask the user how much loan terms in years (y)
        //Ask the user how much is the monthly payments (n)
            //12(because 12 months = 1 year) * y
        //Ask the user how much is the monthly interest Rate (i)
    }
    //Create a method that calculates the monthly payment
        // M = P × (i * (1 + i)^n / ( (1 + i)^n ) - 1)
    //Create a method that calculates the annual interest rate
        //Total interest = (M * n) - P
    //Create a method that displays the expected monthly payment
    // and the total interest paid
}
