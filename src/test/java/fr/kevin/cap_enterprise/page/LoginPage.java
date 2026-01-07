package fr.kevin.cap_enterprise.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@PageUrl("https://opensource-demo.orangehrmlive.com/")
public class LoginPage extends FluentPage {

    @FindBy(name = "username")
    private FluentWebElement usernameInput;

    @FindBy(name = "password")
    private FluentWebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private FluentWebElement submitButton;

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

}