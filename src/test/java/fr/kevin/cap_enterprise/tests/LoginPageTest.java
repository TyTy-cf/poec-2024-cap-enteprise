package fr.kevin.cap_enterprise.tests;

import fr.kevin.cap_enterprise.page.HomePage;
import fr.kevin.cap_enterprise.page.LoginPage;
import fr.kevin.cap_enterprise.utils.Constants;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.fluentlenium.adapter.junit.jupiter.FluentTest;
import org.fluentlenium.configuration.FluentConfiguration;
import org.fluentlenium.core.annotation.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.assertj.core.api.Assertions.assertThat;

@FluentConfiguration(baseUrl = Constants.BASE_URL)
@Epic("OrangeHRM")
@Feature("Authentication")
public class LoginPageTest extends FluentTest {

    @Page
    private LoginPage loginPage;

    @Page
    private HomePage homePage;

    @Override
    public WebDriver newWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Test
    @DisplayName("Test login KO - Invalid credentials")
    @Story("Failed login")
    @Description("Vérifier que l'utilisateur reste sur la page de login avec des identifiants invalides")
    void testFailedLogin() {
        // Aller sur la page de login
        goTo(loginPage);
        loginPage.isAt();

        // Tenter de se connecter avec de mauvais identifiants
        loginPage
                .fillUsername("admin")
                .fillPassword("wrongpassword")
                .submitExpectingFailure();

        // Vérifier qu'on est toujours sur la page de login
        loginPage.isAt();
        assertThat(getDriver().getCurrentUrl()).contains("/auth/login");
    }

    @Test
    @DisplayName("Test login OK - Valid credentials")
    @Story("Successful login")
    @Description("Vérifier que l'utilisateur est redirigé vers le dashboard avec des identifiants valides")
    void testSuccessfulLogin() {
        goTo(loginPage);
        loginPage.isAt();

        HomePage dashboard = loginPage
                .fillUsername(Constants.VALID_USERNAME)
                .fillPassword(Constants.VALID_PASSWORD)
                .submitExpectingSuccess();

        dashboard.isAt();
        assertThat(dashboard.isDisplayed()).isTrue();
        assertThat(getDriver().getCurrentUrl()).contains("/dashboard/index");
    }

    @Test
    @DisplayName("Test dashboard title")
    @Story("Dashboard verification")
    @Description("Vérifier que le titre du dashboard est correct après connexion")
    void testDashboardTitle() {
        goTo(loginPage);
        loginPage.isAt();

        HomePage dashboard = loginPage
                .fillUsername(Constants.VALID_USERNAME)
                .fillPassword(Constants.VALID_PASSWORD)
                .submitExpectingSuccess();

        dashboard.isAt();
        assertThat(dashboard.getDashboardTitle()).isEqualTo("Dashboard");
    }
}
