package com.explore.spring.interfacetest.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("secondService")
public class SecondServiceImpl implements ServiceInterface{

    @Override
    public String callService() {
        return "Msg from SecondServiceImpl";
    }

}
