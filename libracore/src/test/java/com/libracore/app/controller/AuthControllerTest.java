package com.libracore.app.controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

// import org.junit.jupiter.api.Test;
// import tools.jackson.databind.ObjectMapper;

// import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;

// import com.libracore.app.dto.auth.LoginRequest;
// import com.libracore.app.dto.auth.RegisterRequest;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {
    // @Autowired
    // private MockMvc mockMvc;

    // @Autowired
    // private ObjectMapper objectMapper;

    // @Test
    // void shouldRegisterUserSuccessfully() throws Exception{
    // RegisterRequest request = new RegisterRequest();
    // request.setEmail("test@gmail.com");
    // request.setPassword("password123");
    // request.setFirstName("Test");
    // request.setLastName("Test");

    // mockMvc.perform(post("/api/auth/register")
    // .contentType(MediaType.APPLICATION_JSON)
    // .content(objectMapper.writeValueAsString(request))) 
    // .andExpect(status().isCreated());

    // }

    // @Test
    // void shouldFailWhenEmailIsMissing() throws Exception{

    // RegisterRequest request = new RegisterRequest();

    // request.setPassword("password123");
    // request.setFirstName("Test");
    // request.setLastName("User");

    // mockMvc.perform(post("/api/auth/register")
    // .contentType(MediaType.APPLICATION_JSON)
    // .content(objectMapper.writeValueAsString(request)))
    // .andExpect(status().isBadRequest());

    // }

    // @Test
    // void shouldFailWhenEmailAlreadyExists() throws Exception{

    // RegisterRequest request = new RegisterRequest();

    // request.setEmail("duplicate@example.com");
    // request.setPassword("password123");
    // request.setFirstName("Test");
    // request.setLastName("User");

    // mockMvc.perform(post("/api/auth/register")
    // .contentType(MediaType.APPLICATION_JSON)
    // .content(objectMapper.writeValueAsString(request)))
    // .andExpect(status().isCreated());

    // mockMvc.perform(post("/api/auth/register")
    // .contentType(MediaType.APPLICATION_JSON)
    // .content(objectMapper.writeValueAsString(request)))
    // .andExpect(status().isBadRequest());

    // }

    // @Test
    // void shouldLoginSuccessfully() throws Exception {
    //     RegisterRequest registerRequest = new RegisterRequest();
    //     registerRequest.setEmail("login@example.com");
    //     registerRequest.setPassword("password123");
    //     registerRequest.setFirstName("Login");
    //     registerRequest.setLastName("User");

    //     mockMvc.perform(post("/api/auth/register")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(registerRequest)))
    //             .andExpect(status().isCreated());

    //     // login
    //     LoginRequest loginRequest = new LoginRequest();
    //     loginRequest.setEmail("login@example.com");
    //     loginRequest.setPassword("password123");

    //     mockMvc.perform(post("/api/auth/login")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(loginRequest)))
    //             .andExpect(status().isOk());

    // }
}
