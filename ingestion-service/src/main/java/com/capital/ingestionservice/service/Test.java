package com.capital.ingestionservice.service;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class Test {

    @Value("${myVariable}")
    private String myVariable;


    @PostConstruct
    public void tester() {
        System.out.println("Variable: " + myVariable);
    }


}
