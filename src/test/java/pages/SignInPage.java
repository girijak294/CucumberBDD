package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(className = "logout")
    private WebElement signOutButton;

    @FindBy(xpath = "//p[contains(text(), 'Welcome to your account.')]")
    private WebElement welcomeMessage;

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void submitSignIn() {
        signInButton.click();
    }

    public void signOut() {
        signOutButton.click();
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public String getSignInButtonText() {
        return signInLink.getText();
    }
}
