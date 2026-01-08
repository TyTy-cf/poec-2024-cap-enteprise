package fr.kevin.cap_enterprise.saucedemo.test;

import fr.kevin.cap_enterprise.saucedemo.BaseTest;
import fr.kevin.cap_enterprise.saucedemo.page.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        // assert on redirect
    }

}
