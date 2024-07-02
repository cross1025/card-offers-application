package com.capital.ingestionservice.service;


import com.capital.ingestionservice.dto.IngestionRequestDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface RequestDataVerifierService {

    Mono<ResponseEntity<String>> verifyRequestData(IngestionRequestDTO ingestionRequestDTO);
}
