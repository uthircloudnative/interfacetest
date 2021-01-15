package com.explore.spring.interfacetest.controller;

import com.explore.spring.interfacetest.model.Response;
import com.explore.spring.interfacetest.service.ServiceInterface;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FirstController.class)
public class FirstControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("firstService")
    private ServiceInterface serviceInterface;

    @Test
    void callFirstServiceTest() throws Exception {

        Response expected = new Response("This is first controller1");
        when(serviceInterface.callService()).thenReturn("This is first controller1");

        mockMvc.perform(MockMvcRequestBuilders.get("/callfirstservice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.msg").value(expected.getMsg()))
                .andDo(print());
    }



}
