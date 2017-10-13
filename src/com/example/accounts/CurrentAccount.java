package com.example.accounts;

/**
 * Subclass of Account but with a flexible overdraft facility which has a
 * maxAuthorisedOverdraft.
 */
public class CurrentAccount extends Account {

    private double overdraft;
    private double maxAuthorisedOverdraft;

    /**
     * Constructor for the CurrentAccount class which inherits the balance and
     * CustomerDetails from the Account class, taking 2 arguments and initiates
     * overdraft and maxAuthorisedOverdraft to zero.
     * @param balance the balance of the CurrentAccount
     * @param details the CustomerDetails of the CurrentAccount
     */
    public CurrentAccount(double balance, CustomerDetails details, String pin) {
        super(balance, details, pin);
        this.overdraft = 0;
        this.maxAuthorisedOverdraft = 0;
    }

    /**
     * Constructor for the CurrentAccount class which inherits the balance and
     * CustomerDetails from its super class, the Account class. It has 2 extra
     * instance variables, overdraft and maxAuthorisedOverdraft.
     * @param balance the balance of the CurrentAccount
     * @param details the CustomerDetails of the CurrentAccount
     * @param overdraft the current overdraft of the CurrentAccount
     * @param maxAuthorisedOverdraft the maximum authorised overdraft of the current account
     */
    public CurrentAccount(double balance, CustomerDetails details, String pin, double overdraft, double maxAuthorisedOverdraft) {
        super(balance, details, pin);
        this.overdraft = overdraft;
        this.maxAuthorisedOverdraft = maxAuthorisedOverdraft;
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
     * Overrides the Account withdraw method so that this CurrentAccounts overdraft
     * is taken into account.
     *
     * @param amount the amount to withdraw
     * @return true if the withdrawal is successful and false otherwise
     */
    @Override
    public boolean withdraw(double amount) {
        boolean success = false;
        if (amount <= this.getBalance() + this.getOverdraft() && amount >= 0) {
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
}