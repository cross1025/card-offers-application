package com.capital.ingestionservice.controller;

import com.capital.ingestionservice.dto.RequestDTO;
import com.capital.ingestionservice.service.RequestDataVerifierService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/capital/ingestion")
@AllArgsConstructor
public class IngestionController {




    private final RequestDataVerifierService requestDataVerifierService;

    @PostMapping("/card-request")
    public ResponseEntity<String> handleRequest(@RequestBody RequestDTO request) {
        return requestDataVerifierService.verifyRequestData(request);
    }

}
