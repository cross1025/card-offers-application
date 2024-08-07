package com.capital.ingestionservice.controller;

import com.capital.ingestionservice.dto.IngestionRequestDTO;
import com.capital.ingestionservice.service.RequestDataVerifierService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/capital/ingestion")
@AllArgsConstructor
public class IngestionController {




    private final RequestDataVerifierService requestDataVerifierService;

    @PostMapping("/card-request")
    public Mono<ResponseEntity<String>> handleRequest(@RequestBody IngestionRequestDTO request) {
        return requestDataVerifierService.verifyRequestData(request);
    }

}
