package fr.kevin.cap_enterprise.gog.test;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    static void set(WebDriver driver) {
        webDriver.set(driver);
    }

    public static WebDriver get() {
        return Optional.ofNullable(webDriver.get())
                .orElseThrow(() -> new IllegalStateException("Driver NOT initialised"));
    }

    static void remove() {
        webDriver.remove();
    }
}

