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
public class BookingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void bookingShouldReturnBadRequestOnMissingInput() throws Exception {
        this.mockMvc
                .perform(post("/book"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldBookSuccessfullyWithValidInputData() throws Exception {
        JSONObject json = new JSONObject();
        json.put("fromXAxis", 1L);
        json.put("fromYAxis", 1L);
        json.put("toXAxis", 2L);
        json.put("toYAxis", 2L);
        json.put("userId", 1000000000000000001L);
        this.mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON).content(json.toString()))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldNotBookSuccessfullyWithIncompleteInputData() throws Exception {
        JSONObject json = new JSONObject();
        json.put("fromXAxis", 1L);
        json.put("fromYAxis", 1L);
        json.put("userId", 1000000000000000001L);
        this.mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON).content(json.toString()))
                .andExpect(status().isBadRequest());
    }

}
