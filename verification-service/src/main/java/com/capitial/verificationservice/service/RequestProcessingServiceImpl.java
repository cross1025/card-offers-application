package com.capitial.verificationservice.service;

import com.capitial.verificationservice.dto.VerificationFromIngestionDTO;
import org.springframework.stereotype.Service;

@Service
public class RequestProcessingServiceImpl implements RequestProcessingService {

    public void processRequest(VerificationFromIngestionDTO verificationFromIngestionDTO) {
        System.out.println("Log Later: Verification service received requestDTO");
        System.out.println(verificationFromIngestionDTO.getFirstName() + " Received");




    }

}
