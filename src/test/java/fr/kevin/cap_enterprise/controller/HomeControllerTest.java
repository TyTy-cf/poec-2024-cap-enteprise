package fr.kevin.cap_enterprise.controller;

import fr.kevin.cap_enterprise.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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