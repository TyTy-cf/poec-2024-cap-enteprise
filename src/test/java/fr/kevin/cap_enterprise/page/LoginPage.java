package fr.kevin.cap_enterprise.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@PageUrl("/web/index.php/auth/login")
public class LoginPage extends FluentPage {

    @FindBy(name = "username")
    private FluentWebElement usernameInput;

    @FindBy(name = "password")
    private FluentWebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private FluentWebElement submitButton;

    @FindBy(className = "orangehrm-login-slot")
    private FluentWebElement loginPanel;

    @Override
    public void isAt() {
        await().atMost(Duration.ofSeconds(10))
                .until(loginPanel).displayed();
    }

    public LoginPage fillUsername(String username) {
        await().atMost(Duration.ofSeconds(10))
                .until(usernameInput).clickable();
        usernameInput.fill().with(username);
        return this;
    }

    public LoginPage fillPassword(String password) {
        await().atMost(Duration.ofSeconds(10))
                .until(passwordInput).clickable();
        passwordInput.fill().with(password);
        return this;
    }

    public void submit() {
        await().atMost(Duration.ofSeconds(10))
                .until(submitButton).clickable();
        submitButton.click();
    }

    public HomePage submitExpectingSuccess() {
        submit();
        return newInstance(HomePage.class);
    }

    public LoginPage submitExpectingFailure() {
        submit();
        return this;
    }
}
