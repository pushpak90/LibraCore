package com.libracore.app.controller;


// import com.libracore.app.dto.auth.RegisterRequest;

// import tools.jackson.databind.ObjectMapper;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;

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
    //     RegisterRequest request = new RegisterRequest();
    //     request.setEmail("test@gmail.com");
    //     request.setPassword("password123");
    //     request.setFirstName("Test");
    //     request.setLastName("Test");

    //     mockMvc.perform(post("/api/auth/register")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content(objectMapper.writeValueAsString(request)))
    //             .andExpect(status().isCreated());

    // }

    // @Test
    // void shouldFailWhenEmailIsMissing() throws Exception{

    //     RegisterRequest request = new RegisterRequest();

    //     request.setPassword("password123");
    //     request.setFirstName("Test");
    //     request.setLastName("User");

    //     mockMvc.perform(post("/api/auth/register")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(objectMapper.writeValueAsString(request)))
    //         .andExpect(status().isBadRequest());

    // }

    // @Test
    // void shouldFailWhenEmailAlreadyExists() throws Exception{

    //     RegisterRequest request = new RegisterRequest();

    //      request.setEmail("duplicate@example.com");
    //     request.setPassword("password123");
    //     request.setFirstName("Test");
    //     request.setLastName("User");

    //     mockMvc.perform(post("/api/auth/register")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content(objectMapper.writeValueAsString(request)))
    //             .andExpect(status().isCreated());

    //     mockMvc.perform(post("/api/auth/register")
    //                     .contentType(MediaType.APPLICATION_JSON)
    //                     .content(objectMapper.writeValueAsString(request)))
    //             .andExpect(status().isBadRequest());

    // }
}
