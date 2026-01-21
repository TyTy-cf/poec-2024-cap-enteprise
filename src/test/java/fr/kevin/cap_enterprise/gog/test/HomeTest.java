package fr.kevin.cap_enterprise.gog.test;

import fr.kevin.cap_enterprise.gog.BaseTest;
import fr.kevin.cap_enterprise.gog.page.HomePage;
import fr.kevin.cap_enterprise.gog.page.SearchResultsPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {

    @Feature("Fonctionnalité de recherche")
    @Story("User story : rechercher un jeu")
    @Severity(SeverityLevel.NORMAL)
    @Description("Super description de la barre de recherche")
    @Test
    public void testSearch() {
        SearchResultsPage searchResultsPage = (new HomePage(driver))
                .open()
                .searchGame("Cyberpunk");
        assertTrue(searchResultsPage.getCurrentUrl().contains("Cyberpunk"));
    }

    @Test
    public void testSearchFailed() {
        SearchResultsPage searchResultsPage = (new HomePage(driver))
                .open()
                .searchGame("Cyberpunk");
        assertFalse(searchResultsPage.getCurrentUrl().contains("Cyberpunk"));
    }

}
