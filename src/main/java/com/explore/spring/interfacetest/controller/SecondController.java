package com.explore.spring.interfacetest.controller;

import com.explore.spring.interfacetest.model.Response;
import com.explore.spring.interfacetest.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondController {


    private ServiceInterface serviceInterface;

    public SecondController(@Qualifier("secondService") ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @GetMapping("/callsecondservice")
    public Response callSecondService(){
        return new Response(serviceInterface.callService());
    }


}
