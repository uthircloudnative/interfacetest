package com.explore.spring.interfacetest.it;

import com.explore.spring.interfacetest.model.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecondControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFirstServiceMsg() throws Exception {

        Response expected = new Response("Msg from SecondServiceImpl");
        mockMvc.perform(MockMvcRequestBuilders.get("/callsecondservice"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(expected)));
    }
}

