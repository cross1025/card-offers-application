package com.capital.ingestionservice.service;

import com.capital.ingestionservice.dto.IngestionRequestDTO;
import com.capital.ingestionservice.entity.IngestionRequest;
import com.capital.ingestionservice.repo.IngestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RequestDataVerifierServiceImpl implements RequestDataVerifierService {

    private final IngestionRepository ingestionRepository;

    @Value("${verificationRequestUrl}")
    private String verificationRequestUrl;

    private final WebClient.Builder webClientBuilder;

    public Mono<ResponseEntity<String>> verifyRequestData(IngestionRequestDTO ingestionRequestDTO) {

        if(ingestionRequestDTO == null) {
            return Mono.just(new ResponseEntity<>("Requests Data was null", HttpStatus.BAD_REQUEST));
        }

        if(ingestionRequestDTO.getFirstName() == null || ingestionRequestDTO.getLastName() == null || ingestionRequestDTO.getLast4SSN() == null
        || ingestionRequestDTO.getProviderSource() == null) {
            return Mono.just(new ResponseEntity<>("1 or more required fields were null", HttpStatus.BAD_REQUEST));
        }


        saveRequest(ingestionRequestDTO);

        System.out.println("log requestDTO ingestionid to ensure it has one");


        WebClient webClient = webClientBuilder.build();

        return webClient.post()
                .uri(verificationRequestUrl)
                .bodyValue(ingestionRequestDTO)
                .retrieve()
                .bodyToMono(String.class)
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .onErrorResume(error -> {
                    return Mono.just(new ResponseEntity<>("Error processing request", HttpStatus.BAD_REQUEST));
                });
    }

    public void saveRequest(IngestionRequestDTO ingestionRequestDTO) {
        IngestionRequest ingestionRequest = new IngestionRequest();
        ingestionRequest.setFirstName(ingestionRequestDTO.getFirstName());
        ingestionRequest.setMiddleName(ingestionRequestDTO.getMiddleName());
        ingestionRequest.setLastName(ingestionRequestDTO.getLastName());
        ingestionRequest.setEmail(ingestionRequestDTO.getEmail());
        ingestionRequest.setReceivedCreditScore(ingestionRequestDTO.getReceivedCreditScore());
        ingestionRequest.setLast4SSN(ingestionRequestDTO.getLast4SSN());
        ingestionRequest.setPhoneNumber(ingestionRequestDTO.getPhoneNumber());
        ingestionRequest.setProviderSource(ingestionRequestDTO.getProviderSource());
        ingestionRequest.setAnnualIncome(ingestionRequestDTO.getAnnualIncome());
        ingestionRequest.setEmployed(ingestionRequestDTO.getEmployed());
        ingestionRequest.setDebtToIncomeRatio(ingestionRequestDTO.getDebtToIncomeRatio());
        ingestionRequest.setPriorCapitalCredit(ingestionRequestDTO.getPriorCapitalCredit());
        ingestionRepository.save(ingestionRequest);
        System.out.println("request saved add logging here later");
        ingestionRequestDTO.setIngestionId(ingestionRequest.getId());


    }

}


