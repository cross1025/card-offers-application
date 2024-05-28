package com.capitial.verificationservice.controller;

import com.capitial.verificationservice.dto.RequestDTO;
import com.capitial.verificationservice.service.RequestProcessingService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("capital/verificationservice/internal")
@RequiredArgsConstructor
@Setter
@Getter
public class InternalVerificationController {

    private final RequestProcessingService requestProcessingService;

    @PostMapping("/ingestion-request")
    public void handleRequest(@RequestBody RequestDTO requestDTO) {
        requestProcessingService.processRequest(requestDTO);
    }

}
