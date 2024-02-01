package fr.kevin.cap_enterprise.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAccessLogin() throws Exception {
        mockMvc.perform(get("/login"))
            .andExpect(status().isOk());
    }

    @Test
    public void testModelAndViewLogin() throws Exception {
        mockMvc.perform(get("/login").with(anonymous()))
            .andExpect(view().name("security/login"));
    }

    @Test
    public void testAccessRegister() throws Exception {
        mockMvc.perform(get("/inscription"))
            .andExpect(status().isOk());
    }

    @Test
    public void testModelAndViewRegister() throws Exception {
        mockMvc.perform(get("/inscription").with(anonymous()))
                .andExpect(view().name("security/register"));
    }

    @Test
    public void testFormRegister() throws Exception {
        mockMvc.perform(post("/login").with(anonymous())
            .param("username", "joyrider")
            .param("password", "12345")
            .with(csrf()))
            .andExpect(status().is3xxRedirection());
    }

}