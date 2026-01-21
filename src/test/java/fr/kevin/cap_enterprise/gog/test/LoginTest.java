package fr.kevin.cap_enterprise.gog.test;

import fr.kevin.cap_enterprise.gog.BaseTest;
import fr.kevin.cap_enterprise.gog.page.LoginPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Step("Test login is valid")
//    @Test
    public void testLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(false, "Test volontairement échoué");
    }

}
