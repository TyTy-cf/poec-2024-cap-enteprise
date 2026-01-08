package fr.kevin.cap_enterprise.gog.page;

import fr.kevin.cap_enterprise.gog.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    private final By titleSearch = By.cssSelector("h1.page-header");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

}
