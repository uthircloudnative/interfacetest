package com.explore.spring.interfacetest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;

import org.springframework.stereotype.Service;


public class FirstServiceImplTest {

    private FirstServiceImpl firstServiceImpl;

    @BeforeEach
    void init() {
        firstServiceImpl = new FirstServiceImpl();
    }

    @Test
    void testFirstServiceMsg() {
        String actual = firstServiceImpl.callService();
        assertEquals("Msg from FirstServiceImpl",actual);
    }
}
