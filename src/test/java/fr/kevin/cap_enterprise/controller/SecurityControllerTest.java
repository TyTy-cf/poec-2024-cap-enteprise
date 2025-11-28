package fr.kevin.cap_enterprise.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityControllerTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void testLoginPage() {
        driver.get("http://localhost:8080/login");
        assert driver.getTitle().contains("Se connecter");
    }

//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void testAccessLogin() throws Exception {
//        mockMvc.perform(get("/login"))
//            .andExpect(status().isOk());
//    }
//
//    @Test
//    public void testModelAndViewLogin() throws Exception {
//        mockMvc.perform(get("/login").with(anonymous()))
//            .andExpect(view().name("security/login"));
//    }
//
//    @Test
//    public void testFormLogin() throws Exception {
//        mockMvc.perform(post("/login").with(anonymous())
//                        .param("username", "joyrider")
//                        .param("password", "12345")
//                        .with(csrf()))
//                .andExpect(status().is3xxRedirection());
//    }
//
//    @Test
//    public void testAccessRegister() throws Exception {
//        mockMvc.perform(get("/inscription"))
//            .andExpect(status().isOk());
//    }
//
//    @Test
//    public void testModelAndViewRegister() throws Exception {
//        mockMvc.perform(get("/inscription").with(anonymous()))
//            .andExpect(view().name("security/register"));
//    }
//
//    @Test
//    public void testFormRegisterOK() throws Exception {
//        mockMvc.perform(post("/inscription").with(anonymous())
//            .param("nickname", "toto")
//            .param("email", "toto@gmail.com")
//            .param("birthedAt", "2000-10-10")
//            .param("password", "12345")
//            .with(csrf()))
//            .andExpect(status().is3xxRedirection());
//    }
//
//    @Test
//    public void testFormRegisterKO() throws Exception {
//        mockMvc.perform(post("/inscription").with(anonymous())
//                .param("nickname", "")
//                .param("email", "")
//                .param("birthedAt", "")
//                .param("password", "")
//                .with(csrf()))
//            .andExpect(status().is2xxSuccessful())
//            .andExpect(model().hasErrors());
//    }

}