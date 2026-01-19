package com.libracore.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.libracore.app.dto.auth.LoginRequest;
import com.libracore.app.dto.auth.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestControllerTest {
     @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private String registerAndLogin() throws Exception {

        RegisterRequest register = new RegisterRequest();
        register.setEmail("memberrole@example.com");
        register.setPassword("password123");
        register.setFirstName("Member");
        register.setLastName("User");

        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isCreated());

        LoginRequest login = new LoginRequest();
        login.setEmail("memberrole@example.com");
        login.setPassword("password123");

        String response = mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(login)))
                .andReturn()
                .getResponse()
                .getContentAsString();

        return response.split(":")[1].replace("\"", "").replace("}", "");
    }

    @Test
    void shouldAllowMemberAccess() throws Exception {

        String token = registerAndLogin();

        mockMvc.perform(get("/api/test/member")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDenyAdminAccessForMember() throws Exception {

        String token = registerAndLogin();

        mockMvc.perform(get("/api/test/admin")
                .header("Authorization", "Bearer " + token))
                .andExpect(status().isForbidden());
    }
}
