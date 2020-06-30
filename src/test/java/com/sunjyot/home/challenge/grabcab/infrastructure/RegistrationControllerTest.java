package com.sunjyot.home.challenge.grabcab.infrastructure;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void userCreationShouldReturnBadRequestOnMissingInput() throws Exception {
        this.mockMvc
                .perform(post("/user"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldCreateUserSuccessfullyWithValidInputData() throws Exception {
        JSONObject json = new JSONObject();
        json.put("name", "Name");
        json.put("phone", 9999999999L);
        this.mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON).content(json.toString()))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotCreateUserSuccessfullyWithIncompleteInputData() throws Exception {
        JSONObject json = new JSONObject();
        json.put("name", "Name");
        this.mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON).content(json.toString()))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void cabRegistrationShouldReturnBadRequestOnMissingInput() throws Exception {
        this.mockMvc
                .perform(post("/cab"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldRegisterCabSuccessfullyWithValidInputData() throws Exception {
        JSONObject json = new JSONObject();
        json.put("XAxis", 9L);
        json.put("YAxis", 9L);
        this.mockMvc.perform(post("/cab")
                .contentType(MediaType.APPLICATION_JSON).content(json.toString()))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotRegisterCabSuccessfullyWithIncompleteInputData() throws Exception {
        JSONObject json = new JSONObject();
        json.put("name", "Name");
        this.mockMvc.perform(post("/cab")
                .contentType(MediaType.APPLICATION_JSON).content(json.toString()))
                .andExpect(status().isBadRequest());
    }
}
