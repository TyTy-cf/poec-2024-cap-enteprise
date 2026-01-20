package fr.kevin.cap_enterprise.gog.test;

import fr.kevin.cap_enterprise.gog.BaseTest;
import fr.kevin.cap_enterprise.gog.page.HomePage;
import fr.kevin.cap_enterprise.gog.page.SearchResultsPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void testSearch() {
        SearchResultsPage searchResultsPage = (new HomePage(driver))
                .open()
                .searchGame("Cyberpunk");
        assertTrue(searchResultsPage.getCurrentUrl().contains("Cyberpunk"));
    }

    @Step("Sauvegarder screenshot en cas d'erreur")
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
