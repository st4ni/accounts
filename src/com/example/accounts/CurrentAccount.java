package com.example.accounts;

public class CurrentAccount extends Account {

    private double overdraft;
    private double maxAuthorisedOverdraft;

    public CurrentAccount(double balance, CustomerDetails details) {
        super(balance, details);
        this.overdraft = 0;
        this.maxAuthorisedOverdraft = 0;
    }

    public CurrentAccount(double balance, CustomerDetails details, double overdraft, double maxAuthorisedOverdraft) {
        super(balance, details);
        this.overdraft = overdraft;
        this.maxAuthorisedOverdraft = maxAuthorisedOverdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public double getMaxAuthorisedOverdraft() {
        return maxAuthorisedOverdraft;
    }

    public void setMaxAuthorisedOverdraft(double maxAuthorisedOverdraft) {
        this.maxAuthorisedOverdraft = maxAuthorisedOverdraft;
    }

    public boolean increaseOverdraft(double amount) {
        double newOverdraftRequested = this.overdraft + amount;
        if (newOverdraftRequested <= this.maxAuthorisedOverdraft) {
            this.setOverdraft(this.getOverdraft() + amount);
            return true;
        }
        return false;
    }

    public boolean reduceOverdraft(double amount) {
        if (amount < 0) {
            return false;
        }
        if (amount < this.overdraft) {
            this.setOverdraft(this.getOverdraft() - amount);
            return true;
        }
        return false;
    }
}