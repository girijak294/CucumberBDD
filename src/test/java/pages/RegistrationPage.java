package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(id = "email_create")
    private WebElement emailField;

    @FindBy(id = "SubmitCreate")
    private WebElement submitButton;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(xpath = "//*[contains(text(), 'Your account has been created.')]")
    private WebElement confirmationMessage;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submitRegistration() {
        registerButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
