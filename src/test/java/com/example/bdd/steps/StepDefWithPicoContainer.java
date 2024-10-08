package com.example.bdd.steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.RegistrationPage;
import pages.SignInPage;

public class StepDefWithPicoContainer {

    private WebDriver driver;
    private RegistrationPage registrationPage;
    private SignInPage signInPage;

    public StepDefWithPicoContainer() {
        // Initialize the WebDriver (ensure the path to your WebDriver executable is correct)
        System.setProperty("webdriver.chrome.driver", "\"C:\\Users\\girijabhavani_kudupu\\Desktop\\chromedriver.exe\"");
        this.driver = new ChromeDriver();
        this.registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        this.signInPage = PageFactory.initElements(driver, SignInPage.class);
    }

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @When("I enter valid registration details")
    public void i_enter_valid_registration_details() {
        registrationPage.enterEmail("testuser@example.com");
        registrationPage.enterPassword("Password123");
        registrationPage.submitRegistration();
    }

    @When("I submit the registration form")
    public void i_submit_the_registration_form() {
        registrationPage.submitRegistration();
    }

    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
        // Implement logic to check if the user is registered successfully
        // This could involve checking for a confirmation message or a successful login
        String confirmationMessage = registrationPage.getConfirmationMessage();
        assert confirmationMessage.contains("Your account has been created.");
    }

    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        String confirmationMessage = registrationPage.getConfirmationMessage();
        assert confirmationMessage != null && !confirmationMessage.isEmpty();
    }

    @Given("I am on the sign-in page")
    public void i_am_on_the_sign_in_page() {
        driver.get("http://automationpractice.com/index.php?controller=authentication");
    }

    @When("I enter valid sign-in details")
    public void i_enter_valid_sign_in_details() {
        signInPage.enterEmail("testuser@example.com");
        signInPage.enterPassword("Password123");
        signInPage.submitSignIn();
    }

    @Then("I should be signed in successfully")
    public void i_should_be_signed_in_successfully() {
        // Implement verification logic for successful sign-in
        String welcomeMessage = signInPage.getWelcomeMessage();
        assert welcomeMessage.contains("Welcome to your account.");
    }

    @Given("I am signed in")
    public void i_am_signed_in() {
        i_am_on_the_sign_in_page();
        i_enter_valid_sign_in_details();
    }

    @When("I sign out")
    public void i_sign_out() {
        signInPage.signOut();
    }

    @Then("I should be signed out successfully")
    public void i_should_be_signed_out_successfully() {
        // Verify that the user has been signed out
        String signInButtonText = signInPage.getSignInButtonText();
        assert signInButtonText.equals("Sign in");
    }
}
