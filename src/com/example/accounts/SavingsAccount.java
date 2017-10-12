package com.example.accounts;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(double balance, CustomerDetails details, double interestRate) {
        super(balance, details);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


}
