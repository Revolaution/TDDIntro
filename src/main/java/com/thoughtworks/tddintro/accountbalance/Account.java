package com.thoughtworks.tddintro.accountbalance;

public class Account {
    private Integer startingAmount;

    public Account(int amount){
        this.startingAmount = amount;
    }
    public Integer deposit(int depositAmount){
        return startingAmount + depositAmount;
    }

    public Integer withdraw(int withdrawAmount) {
        if (startingAmount - withdrawAmount < 0){
            return startingAmount;
        }
        return startingAmount - withdrawAmount;
    }
}
