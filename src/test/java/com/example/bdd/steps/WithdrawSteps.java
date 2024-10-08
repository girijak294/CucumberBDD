package com.example.bdd.steps;

import static org.junit.Assert.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.example.bdd.Account;
import com.example.bdd.ATM;

public class WithdrawSteps {
    private Account account;
    private ATM atm;
    private int cashDispensed;

    @Given("I have a balance of ${int} in my account")
    public void i_have_a_balance_of_in_my_account(int balance) {
        account = new Account(balance);
        atm = new ATM();
    }

    @When("I request ${int}")
    public void i_request(int requestAmount) {
        cashDispensed = atm.withdraw(account, requestAmount);
    }

    @Then("${int} should be dispensed")
    public void should_be_dispensed(int expectedAmount) {
        assertEquals(expectedAmount, cashDispensed);
    }
}
