package fr.kevin.cap_enterprise.tests;

import fr.kevin.cap_enterprise.page.HomePage;
import fr.kevin.cap_enterprise.page.LoginPage;
import fr.kevin.cap_enterprise.utils.Constants;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.assertj.core.api.Assertions.assertThat;

@FluentConfiguration(baseUrl = "http://localhost:8080")
public class LoginPageTest extends FluentTest {

    @Page
    private LoginPage loginPage;

    @Page
    private HomePage homePage;

    @Override
    public WebDriver newWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Test
    void failed_login_should_redirect_to_login() {
        goTo(loginPage);
        loginPage.isAt();
        LoginPage page = loginPage
                .setUsername("user@example.com")
                .setPassword("password123")
                .submit();

        assertThat(page.url()).isEqualTo("login?error");
        assertThat(page.isErrorMessageDisplayed()).isEqualTo(true);
    }

    @Test
    void successful_login_should_redirect_to_home() {
        goTo(loginPage);
        loginPage.isAt();
        loginPage.setUsername("admin")
                .setPassword("12345")
                .submit();

        homePage.isAt();

        assertThat(getDriver().getCurrentUrl()).isEqualTo(Constants.BASE_URL + homePage.getUrl());
    }

}