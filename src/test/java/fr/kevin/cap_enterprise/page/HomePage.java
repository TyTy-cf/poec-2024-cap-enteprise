package fr.kevin.cap_enterprise.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@PageUrl("/web/index.php/dashboard/index")
public class HomePage extends FluentPage {

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private FluentWebElement dashboardTitle;

    @FindBy(xpath = "//span[text()='Admin']")
    private FluentWebElement adminMenu;

    @Override
    public void isAt() {
        // Attendre que le dashboard soit affiché
        await().atMost(Duration.ofSeconds(15))
                .until(dashboardTitle).displayed();
    }

    public String getDashboardTitle() {
        await().atMost(Duration.ofSeconds(10))
                .until(dashboardTitle).displayed();
        return dashboardTitle.text();
    }

    public boolean isDisplayed() {
        try {
            await().atMost(Duration.ofSeconds(15))
                    .until(dashboardTitle).displayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
