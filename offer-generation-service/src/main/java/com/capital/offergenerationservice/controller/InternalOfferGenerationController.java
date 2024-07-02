package com.capital.offergenerationservice.controller;

import com.capital.offergenerationservice.dto.OffersFromVerificationDTO;
import com.capital.offergenerationservice.service.OfferGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/capital/offer-generation/internal")
@RequiredArgsConstructor
public class InternalOfferGenerationController {

    private final OfferGenerationService offerGenerationService;

    @PostMapping("/verification-request")
    public ResponseEntity<String> generateOffer(@RequestBody OffersFromVerificationDTO offersFromVerificationDTO) {
        return offerGenerationService.calculateAvailableOffers(offersFromVerificationDTO);
    }


}
