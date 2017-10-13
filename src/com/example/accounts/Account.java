package com.example.accounts;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Abstract class Account represents a bank account
 */
public abstract class Account{

    private double balance;
    private CustomerDetails details;

    /**
     * Constructor for class Account which takes 2 paramaters, balance which is a double and details
     * which is an object of class CustomerDetails
     *
     * @param balance the balance of the account
     * @param details the customer details of the account holder
     */
    public Account(double balance, CustomerDetails details) {
        this.balance = balance;
        this.details = details;
    }

    /**
     *
     * @return the balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the account
     * @param balance the balance of the account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @return the customers details as an object of class CustomerDetails
     */
    public CustomerDetails getDetails() {
        return details;
    }

    /**
     * Sets the customer details of the account.
     * @param details an object of class CustomerDetails
     */
    public void setDetails(CustomerDetails details) {
        this.details = details;
    }

    /**
     * Withdraws anAmount from this accounts balance and deposits it into anAccount
     * if the withdrawal was successful.
     * @param anAmount the amount to be transfered from this account to anAccount
     * @param anAccount the account to be credited
     * @return true if the transfer is successful and false if there are insufficent funds
     * in this account.
     */
    public boolean transfer(double anAmount, Account anAccount) {
        if (this.withdraw(anAmount)) {
            anAccount.deposit(anAmount);
            return true;
        }
        return false;
    }

    /**
     * Withdraws anAmount from this account balance.
     * @param anAmount the amount to be withdrawn from this account
     * @return true if the withdrawal is successful and false if there are insufficent funds.
     */
    public boolean withdraw(double anAmount) {
        if (this.getBalance() >= anAmount && anAmount >= 0) {
            this.setBalance(this.getBalance() - anAmount);
            return true;
        }
        return false;
    }

    /**
     * Deposits anAmount into this accounts balance as long as it is positive.
     * @param anAmount the amount to be deposited into this account.
     */
    public void deposit(double anAmount) {
        if (anAmount >= 0) {
            this.setBalance(this.getBalance() + anAmount);
        }
    }




    public static void main(String[] args) {
        CustomerDetails peter = new CustomerDetails("Peter", "Smith", "10 Downing Street",
                "07711082689", "01/01/2000", "00001");
        CustomerDetails john = new CustomerDetails("John","Barns", "11 Downing Street",
                "07978098780", "25/12/2000", "00002");
        CurrentAccount petersCurrentAccount = new CurrentAccount(90000, peter, "9638", 10000, 20000);
        SavingsAccount johnsSavingsAccount = new SavingsAccount(200000, john,  5);
        johnsSavingsAccount.transfer(50000, petersCurrentAccount);
        petersCurrentAccount.deposit(800000);
        System.out.println(johnsSavingsAccount.getBalance());
        System.out.println(petersCurrentAccount.getBalance());
        System.out.println(petersCurrentAccount.increaseOverdraft(9000));
        System.out.println(petersCurrentAccount.increaseOverdraft(2000));
        petersCurrentAccount.transfer(85000, johnsSavingsAccount);
        System.out.println(johnsSavingsAccount.getBalance());
        System.out.println(petersCurrentAccount.getBalance());
        System.out.println(petersCurrentAccount.transfer(5000, johnsSavingsAccount));
        System.out.println(johnsSavingsAccount.getBalance());
        System.out.println(petersCurrentAccount.getBalance());

    }
}
