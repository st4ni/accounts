package com.example.accounts;

/**
 * Class account represents a bank account
 */
public class Account {

    private double balance;
    private CustomerDetails details;

    /**
     * Constructor for class Account which takes 2 paramaters, balance which is a double and details
     * which is an object of class CustomerDetails
     *
     * @param balance
     * @param details
     */
    public Account(double balance, CustomerDetails details) {
        this.balance = balance;
        this.details = details;
    }

    /**
     * Returns the balance of the instance
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the instance
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Returns the customers details as an object of class CustomerDetails
     * @return
     */
    public CustomerDetails getDetails() {
        return details;
    }

    /**
     * Sets the customer details as an object of class CustomerDetails which is
     * the only parameter
     * @param details
     */
    public void setDetails(CustomerDetails details) {
        this.details = details;
    }

    /**
     * Transfers anAmount from the instances balance to anAccount's balance. Returns
     * True if successful and false if there are insufficent funds
     * @param anAmount
     * @param anAccount
     * @return
     */
    public boolean transfer(double anAmount, Account anAccount) {
        if (this.getBalance() >= anAmount) {
            this.setBalance(this.getBalance() - anAmount);
            anAccount.setBalance(anAccount.getBalance() + anAmount);
            return true;
        }
        return false;
    }

    /**
     * Withdraws anAmount from the instances balance. Returns
     * true if successful and false if there are insufficent funds.
     * @param anAmount
     * @return
     */
    public boolean withdraw(double anAmount) {
        if (this.getBalance() >= anAmount) {
            this.setBalance(this.getBalance() - anAmount);
            return true;
        }
        return false;
    }

    /**
     * Deposits anAmount into the instances balance as long as it is positive.
     * @param anAmount
     */
    public void deposit(double anAmount) {
        if (anAmount >= 0) {
            this.setBalance(this.getBalance() + anAmount);
        }
    }

    public static void main(String[] args) {
        CustomerDetails peter = new CustomerDetails("Peter", "Smith", "10 Downing Street",
                "07711082689", "00001");
        CustomerDetails john = new CustomerDetails("John","Barns", "11 Downing Street",
                "07978098780", "00002");
        CurrentAccount petersCurrentAccount = new CurrentAccount(90000, peter, 10000, 20000);
        SavingsAccount johnsSavingsAccount = new SavingsAccount(200000, john, 5);
        johnsSavingsAccount.transfer(50000, petersCurrentAccount);
        System.out.println(johnsSavingsAccount.getBalance());
        System.out.println(petersCurrentAccount.getBalance());

    }

}
