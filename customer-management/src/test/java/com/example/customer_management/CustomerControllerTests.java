package com.example.customer_management;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateCustomer() throws Exception {
        String customerJson = "{\"name\":\"ANASSBD\",\"email\":\"anassbd@example.com\",\"phone\":\"555-1234\",\"address\":\"456 fhjh St\"}";

        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson)
                .with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "password"))) // Use your username and password here
            .andExpect(status().isCreated());
    }
}
