package fr.kevin.cap_enterprise.saucedemo.page;

import fr.kevin.cap_enterprise.saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By searchBtn = By.cssSelector("a[hook-test='menuSearch'");
    private final By searchBar = By.cssSelector("input[hook-test='menuSearchInput'");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchItem(String item) {
        goTo(ROOT_URL);
        waitUntil(searchBtn).click();
        type(searchBar, item);
    }

}
