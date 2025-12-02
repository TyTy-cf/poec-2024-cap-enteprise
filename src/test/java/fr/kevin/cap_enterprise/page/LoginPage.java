package fr.kevin.cap_enterprise.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@PageUrl("/login")
public class LoginPage extends FluentPage {

    @FindBy(css = "h1.form-heading")
    private FluentWebElement loginMessage;

    @FindBy(name = "username")
    private FluentWebElement usernameInput;

    @FindBy(name = "password")
    private FluentWebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private FluentWebElement submitButton;

    @FindBy(css = "p.invalid-feedback")
    private FluentWebElement errorMessage;

    @Override
    public void isAt() {
        await().atMost(Duration.ofSeconds(10)).until(loginMessage).displayed();
    }

    public LoginPage setUsername(String username) {
        usernameInput.fill().with(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput.fill().with(password);
        return this;
    }

    public LoginPage submit() {
        submitButton.click();
        return this;
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.displayed();
    }

}