package com.explore.spring.interfacetest.controller;

import com.explore.spring.interfacetest.model.Response;
import com.explore.spring.interfacetest.service.ServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SecondController.class)
public class SecondControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("secondService")
    private ServiceInterface serviceInterface;

    @Test
    void callSecondServiceTest() throws Exception {

        Response expected = new Response("This is from SecondServiceImpl");

        when(serviceInterface.callService()).thenReturn("This is from SecondServiceImpl");

        mockMvc.perform(MockMvcRequestBuilders.get("/callsecondservice"))
                .andExpect(status().isOk())
                .andExpect(result -> assertThat(result.getResponse().getContentAsString()).isEqualTo(new ObjectMapper().writeValueAsString(expected)));
    }




}
