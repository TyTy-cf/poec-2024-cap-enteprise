package fr.kevin.cap_enterprise.gog.test;

import fr.kevin.cap_enterprise.gog.BaseTest;
import fr.kevin.cap_enterprise.gog.page.LoginPage;
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
