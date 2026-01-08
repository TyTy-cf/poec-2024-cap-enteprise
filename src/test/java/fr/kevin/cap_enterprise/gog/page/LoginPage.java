package fr.kevin.cap_enterprise.gog.page;

import fr.kevin.cap_enterprise.gog.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.cssSelector("input[name='username']");
    private final By passwordField = By.cssSelector("input[name='password']");
    private final By submitButton = By.cssSelector("input[id='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        goTo(ROOT_URL + "/login");
        type(usernameField, username);
        type(passwordField, password);
        waitClickable(submitButton).click();
    }

    public By getUsernameField() {
        return usernameField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getSubmitButton() {
        return submitButton;
    }
}
