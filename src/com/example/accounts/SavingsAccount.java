package com.example.accounts;

import java.util.Scanner;

/**
 * The SavingsAccount class is a subclass of the Account class but also has an interestRate
 * attribute.
 */
public class SavingsAccount extends Account implements Security{

    private double interestRate;

    /**
     * Constructor of class SavingsAccount invoking the constructor of its ancestor Account class
     * but adding an interestRate instance variable
     * @param balance
     * @param details the customer details
     * @param interestRate
     */
    public SavingsAccount(double balance, CustomerDetails details, double interestRate) {
        super(balance, details);
        this.interestRate = interestRate;
    }

    /**
     *
     * @return the current interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Sets the interest rate to that of the argument.
     * @param interestRate
     */
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * Overrides the Account withdraw method so that this SavingsAccount uses Security.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal is successful and false otherwise
     */
    @Override
    public boolean withdraw(double amount) {
        if (this.authorised()) {
            return super.withdraw(amount);
        }
        else {
            return false;
        }
    }

    @Override
    public boolean authorised() {
        boolean correctDateOfBirthEntered = false;
        int tries = 0;
        while (!correctDateOfBirthEntered && tries < 3) {
            System.out.println(this.getDetails().getFirstName() + ", what is your date of birth?");
            Scanner scanner = new Scanner(System.in);
            String dateOfBirthEntered = scanner.nextLine();
            if (dateOfBirthEntered.equals(this.getDetails().getDateOfBirth())) {
                correctDateOfBirthEntered = true;
                System.out.println("That is correct");
            } else {
                correctDateOfBirthEntered = false;
                System.out.print("Incorrect");
            }
            tries++;
            if (!correctDateOfBirthEntered && tries < 3) {
                System.out.println(" try again!");
            }
            else if (!correctDateOfBirthEntered && tries >= 3){
                System.out.println();
                System.out.println("You've had three tries your account has been frozen");
            }
        }
        return correctDateOfBirthEntered;
    }
}
