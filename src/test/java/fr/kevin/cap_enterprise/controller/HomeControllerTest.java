package fr.kevin.cap_enterprise.controller;

import fr.kevin.cap_enterprise.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeControllerTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOpenWebsite() {
        driver.get(Constants.BASE_URL);
        assert driver.getTitle().contains("Se connecter");
    }

    @Test
    public void testFillForm() {
        String loginUrl = Constants.BASE_URL + "/login";
        driver.get(loginUrl);
        WebElement emailField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        emailField.sendKeys("fail@toto.fr");
        passwordField.sendKeys("12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginUrl = loginUrl + "?error";
        wait.until(ExpectedConditions.urlToBe(loginUrl));

        assert driver.findElement(By.cssSelector("p.invalid-feedback")).isDisplayed();
    }

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ReviewService reviewService;
//
//    @Test
//    public void testRedirectFromHomeAnonymous() throws Exception {
//        mockMvc.perform(get("/").with(anonymous()))
//            .andExpect(status().is3xxRedirection());
//    }
//
//    @Test
//    public void testHomeLogged() throws Exception {
//        mockMvc.perform(get("/").with(user("ipfreely").roles("MODERATOR")))
//            .andExpect(status().isOk());
//    }
//
//    @Test
//    public void testPageNumberInfos() throws Exception {
//        mockMvc.perform(get("/?sort=moderator,asc")
//                .with(user("ipfreely").roles("MODERATOR"))
//            )
//            .andExpect(status().isOk())
//            .andExpect(view().name("index"))
//            .andExpect(model().attribute(
//                "pageReviews",
//                reviewService.getPageReviewByNickname(
//                    "ipfreely",
//                    PageRequest.of(
//                        1,
//                        6,
//                        Sort.by("moderator"
//                    ).ascending())
//                )
//            )
//        );
//    }

}