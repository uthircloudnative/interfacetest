package com.explore.spring.interfacetest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static  org.junit.jupiter.api.Assertions.*;
import org.springframework.stereotype.Service;

@Service
public class SecondServiceImplTest {

    private SecondServiceImpl secondServiceImpl;

    @BeforeEach
    void init(){
        secondServiceImpl = new SecondServiceImpl();
    }

    @Test
    void callServiceTest(){

        String actual = secondServiceImpl.callService();
        String expected = "Msg from SecondServiceImpl";
        assertEquals(expected,actual);
    }

}
