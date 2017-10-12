package com.example.accounts;

public class Account {

    private double balance;
    private CustomerDetails details;

    public Account(double balance, CustomerDetails details) {
        this.balance = balance;
        this.details = details;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public CustomerDetails getDetails() {
        return details;
    }

    public void setDetails(CustomerDetails details) {
        this.details = details;
    }

    public boolean transfer(double anAmount, Account anAccount) {
        if (this.getBalance() >= anAmount) {
            this.setBalance(this.getBalance() - anAmount);
            anAccount.setBalance(anAccount.getBalance() + anAmount);
            return true;
        }
        return false;
    }

    public boolean withdraw(double anAmount) {
        if (this.getBalance() >= anAmount) {
            this.setBalance(this.getBalance() - anAmount);
            return true;
        }
        return false;
    }

    public void deposit(double anAmount) {
        this.setBalance(this.getBalance() + anAmount);
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
