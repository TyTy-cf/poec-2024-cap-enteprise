package fr.kevin.cap_enterprise.gog.page;

import fr.kevin.cap_enterprise.gog.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By searchBtn = By.cssSelector("a[hook-test='menuSearch']");
    private final By searchBar = By.cssSelector("input[hook-test='menuSearchInput']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        goTo(ROOT_URL);
        return this;
    }

    public SearchResultsPage searchGame(String gameName) {
        waitClickable(searchBtn).click();
        type(searchBar, gameName);
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

}
