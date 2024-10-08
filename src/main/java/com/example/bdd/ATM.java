package com.example.bdd;

public class ATM {
    public int withdraw(Account account, int amount) {
        if (account.getBalance() >= amount) {
            account.deductBalance(amount);
            return amount;
        } else {
            return 0; // If insufficient funds, dispense nothing
        }
    }
}
