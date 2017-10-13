package com.example.accounts;

/**
 * The SavingsAccount class is a subclass of the Account class but also has an interestRate
 * attribute.
 */
public class SavingsAccount extends Account {

    private double interestRate;

    /**
     * Constructor of class SavingsAccount invoking the constructor of its ancestor Account class
     * but adding an interestRate instance variable
     * @param balance
     * @param details the customer details
     * @param interestRate
     */
    public SavingsAccount(double balance, CustomerDetails details, String pin, double interestRate) {
        super(balance, details, pin);
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


}
