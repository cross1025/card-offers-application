package com.capital.ingestionservice.service;

import com.capital.ingestionservice.dto.RequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class RequestDataVerifierServiceImpl implements RequestDataVerifierService {

    @Value("${verificationRequestUrl}")
    private String verificationRequestUrl;

    private final WebClient.Builder webClientBuilder;

    public ResponseEntity<String> verifyRequestData(RequestDTO requestDTO) {

        if(requestDTO == null) {
            return new ResponseEntity<>("Requests Data was null", HttpStatus.BAD_REQUEST);
        }

        if(requestDTO.getFirstName() == null || requestDTO.getLastName() == null || requestDTO.getLast4SSN() == null
        || requestDTO.getProviderSource() == null) {
            return new ResponseEntity<>("1 or more required fields were null", HttpStatus.BAD_REQUEST);
        }

        WebClient webClient = webClientBuilder.build();

        webClient.post()
                .uri(verificationRequestUrl)
                .bodyValue(requestDTO)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe( response -> {
                    System.out.println("THIS WILL BE LOGGED LATER ::  Response :" + response);
                });

        return new ResponseEntity<>("Request is being processed!", HttpStatus.ACCEPTED);


    }

}

