package com.capitial.verificationservice.service;

import com.capitial.verificationservice.dto.RequestDTO;
import org.springframework.stereotype.Service;

@Service
public class RequestProcessingServiceImpl implements RequestProcessingService {

    public void processRequest(RequestDTO requestDTO) {
        System.out.println("Log Later: Verification service received requestDTO");


    }

}
