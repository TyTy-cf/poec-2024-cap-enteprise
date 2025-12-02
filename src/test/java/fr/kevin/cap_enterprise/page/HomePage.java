package fr.kevin.cap_enterprise.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;

import java.time.Duration;

@PageUrl("/")
public class HomePage extends FluentPage {

    @Override
    public void isAt() {
        await().atMost(Duration.ofSeconds(10));
    }

}