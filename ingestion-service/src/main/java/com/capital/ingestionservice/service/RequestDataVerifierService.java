package com.capital.ingestionservice.service;


import com.capital.ingestionservice.dto.RequestDTO;
import org.springframework.http.ResponseEntity;

public interface RequestDataVerifierService {

    ResponseEntity<String> verifyRequestData(RequestDTO requestDTO);
}
