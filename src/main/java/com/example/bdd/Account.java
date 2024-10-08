package com.example.bdd;

public class Account {
    private int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deductBalance(int amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
