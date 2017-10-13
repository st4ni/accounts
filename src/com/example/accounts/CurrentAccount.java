package com.example.accounts;

import java.util.Scanner;

/**
 * Subclass of Account but with a flexible overdraft facility which has a
 * maxAuthorisedOverdraft.
 */
public class CurrentAccount extends Account implements Security{

    private double overdraft;
    private double maxAuthorisedOverdraft;
    private String pin;

    /**
     * Constructor for the CurrentAccount class which inherits the balance and
     * CustomerDetails from the Account class, taking 2 arguments and initiates
     * overdraft and maxAuthorisedOverdraft to zero.
     * @param balance the balance of the CurrentAccount
     * @param details the CustomerDetails of the CurrentAccount
     */
    public CurrentAccount(double balance, CustomerDetails details, String pin) {
        super(balance, details);
        this.overdraft = 0;
        this.maxAuthorisedOverdraft = 0;
    }

    /**
     * Constructor for the CurrentAccount class which inherits the balance and
     * CustomerDetails from its super class, the Account class. It has 2 extra
     * instance variables, overdraft and maxAuthorisedOverdraft.
     *
     * @param balance the balance of the CurrentAccount
     * @param details the CustomerDetails of the CurrentAccount
     * @param overdraft the current overdraft of the CurrentAccount
     * @param maxAuthorisedOverdraft the maximum authorised overdraft of the current account
     */
    public CurrentAccount(double balance, CustomerDetails details, String pin, double overdraft, double maxAuthorisedOverdraft) {
        super(balance, details);
        this.overdraft = overdraft;
        this.maxAuthorisedOverdraft = maxAuthorisedOverdraft;
        this.pin = pin;
    }

    /**
     *
     * @return the current overdraft of the CurrentAccount
     */
    public double getOverdraft() {
        return overdraft;
    }

    /**
     * Sets the current overdraft of the CurrentAccount
     * @param overdraft the current overdraft
     */
    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    /**
     *
     * @return the maximum authorised overdraft
     */
    public double getMaxAuthorisedOverdraft() {
        return maxAuthorisedOverdraft;
    }

    /**
     * Sets the maximum authorised overdraft
     * @param maxAuthorisedOverdraft the maximum authorised overdraft
     */
    public void setMaxAuthorisedOverdraft(double maxAuthorisedOverdraft) {
        this.maxAuthorisedOverdraft = maxAuthorisedOverdraft;
    }

    /**
     *
     * @return this accounts pin.
     */
    public String getPin() {
        return pin;
    }

    /**
     * Sets this accounts pin
     * @param pin this accounts pin
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * Overrides the Account withdraw method so that this CurrentAccounts overdraft
     * is taken into account.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal is successful and false otherwise
     */
    @Override
    public boolean withdraw(double amount) {
        boolean success = false;
        if (this.authorised() && amount <= this.getBalance() + this.getOverdraft() && amount >= 0) {
            this.setBalance(this.getBalance() + amount);
            if (super.withdraw(amount)) {
                success = true;
            }
            this.setBalance(this.getBalance() - amount);
        }
        return success;
    }

    /**
     * Increases the overdraft by the argument if the total overdraft remains below the
     * maximum authorised overdraft.
     * @param amount requested increase in overdraft
     * @return true if overdraft is increased, false otherwise.
     */
    public boolean increaseOverdraft(double amount) {
        double newOverdraftRequested = this.getOverdraft() + amount;
        if (newOverdraftRequested <= this.getMaxAuthorisedOverdraft()) {
            this.setOverdraft(this.getOverdraft() + amount);
            return true;
        }
        return false;
    }

    /**
     * Reduces the overdraft by the argument if the requested amount is positive
     * and is less than or equal to the current overdraft.
     * maximum authorised overdraft.
     * @param amount requested reduction in overdraft
     * @return true if overdraft is reduced, false otherwise.
     */
    public boolean reduceOverdraft(double amount) {
        if (amount < 0) {
            return false;
        }
        if (amount <= this.getOverdraft()) {
            this.setOverdraft(this.getOverdraft() - amount);
            return true;
        }
        return false;
    }

    /**
     * Requests a pin to be entered in the standard input and compares with this accounts pin
     * @return true if pin matches within 3 attempts, otherwise false
     */
    public boolean authorised() {
        boolean correctPinEntered = false;
        int tries = 0;
        while (!correctPinEntered && tries < 3) {
            System.out.print(this.getDetails().getFirstName() + " enter your pin: ");
            Scanner scanner = new Scanner(System.in);
            String pinEntered = scanner.nextLine();
            if (pinEntered.equals(this.pin)) {
                correctPinEntered = true;
                System.out.println("Your pin is " + pinEntered + "! shhhhhhh don't tell anyone!!");
            } else {
                correctPinEntered = false;
                System.out.print("Your pin is not " + pinEntered);
            }
            tries++;
            if (!correctPinEntered && tries < 3) {
                System.out.println(" try again!");
            }
            else if (!correctPinEntered && tries >= 3){
                System.out.println();
                System.out.println("You've had three tries so go away!!");
            }
        }
        return correctPinEntered;
    }
}