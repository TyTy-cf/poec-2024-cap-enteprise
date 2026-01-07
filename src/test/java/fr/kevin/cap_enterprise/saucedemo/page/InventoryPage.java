package fr.kevin.cap_enterprise.saucedemo.page;

import fr.kevin.cap_enterprise.saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By titleProduct = By.cssSelector("span.title");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleProduct() {
        return getText(titleProduct);
    }

}
