package fr.kevin.cap_enterprise.gog.test;

import fr.kevin.cap_enterprise.gog.BaseTest;
import fr.kevin.cap_enterprise.gog.page.HomePage;
import fr.kevin.cap_enterprise.gog.page.SearchResultsPage;
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
