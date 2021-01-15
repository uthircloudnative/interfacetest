package com.explore.spring.interfacetest.controller;

import com.explore.spring.interfacetest.model.Response;
import com.explore.spring.interfacetest.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    private ServiceInterface serviceInterface;

    public FirstController(@Qualifier("firstService") ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @GetMapping("/callfirstservice")
    public Response getFirstServiceMsg(){
        return new Response(serviceInterface.callService());
    }

}
