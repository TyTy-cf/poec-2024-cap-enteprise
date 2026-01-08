package fr.kevin.cap_enterprise.saucedemo.test;

import fr.kevin.cap_enterprise.saucedemo.BaseTest;
import fr.kevin.cap_enterprise.saucedemo.page.HomePage;
import fr.kevin.cap_enterprise.saucedemo.page.SearchResultsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void testSearch() {
        SearchResultsPage searchResultsPage = (new HomePage(driver))
                .open()
                .searchGame("Cyberpunk");
        assertTrue(searchResultsPage.getCurrentUrl().contains("Cyberpunk"));
    }

}
