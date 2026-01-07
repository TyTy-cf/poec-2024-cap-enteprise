package fr.kevin.cap_enterprise.saucedemo.test;

import fr.kevin.cap_enterprise.saucedemo.BaseTest;
import fr.kevin.cap_enterprise.saucedemo.page.HomePage;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseTest {

    @Test
    public void testSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.searchItem("Cyberpunk");
    }

}
