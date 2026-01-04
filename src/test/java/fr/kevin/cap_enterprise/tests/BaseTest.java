package fr.kevin.cap_enterprise.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Test
    public void testLoginWithValidCredentials() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Handle windows
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();

        for (String handle : allHandles) {
            driver.switchTo().window(handle);
        }

        driver.switchTo().window(mainWindowHandle);

        // Handle les frames/iframes
        driver.switchTo().frame(0);
        driver.switchTo().frame("frameName"); driver.switchTo().frame(frameElement);
        driver.switchTo().defaultContent();

        // Handle les alertes
        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();
        String alertText = alert.getText();
        alert.sendKeys("input text");





        WebElement usernameField = waitForVisible(By.name("username"));
        usernameField.sendKeys("Admin");
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("admin123");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement dashboardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        assertTrue(dashboardTitle.isDisplayed(), "Le dashboard devrait être affiché après connexion.");

        // Elements
        wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("username")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));

        // Texte
        wait.until(ExpectedConditions.textToBePresentInElement(element, "Text"));

        // URL & Titre
        wait.until(ExpectedConditions.urlContains("/page"));
        wait.until(ExpectedConditions.titleContains("Title"));
        wait.until(ExpectedConditions.titleIs("Exact title"));

        // Attributes
        wait.until(ExpectedConditions.attributeContains(element, "class", "active"));


    }

}
