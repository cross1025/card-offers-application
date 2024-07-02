package com.capitial.verificationservice.service;

import com.capitial.verificationservice.dto.VerificationFromIngestionDTO;

public interface RequestProcessingService {

    void processRequest(VerificationFromIngestionDTO verificationFromIngestionDTO);

}
