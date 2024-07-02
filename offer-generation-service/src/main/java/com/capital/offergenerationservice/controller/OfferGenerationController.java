package com.capital.offergenerationservice.controller;

import com.capital.offergenerationservice.entity.CardOffer;
import com.capital.offergenerationservice.service.OfferGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/captial/offer")
public class OfferGenerationController {

    private final OfferGenerationService offerGenerationService;

    @PostMapping("/newOffer")
    public ResponseEntity<CardOffer> createNewOffer(@RequestBody CardOffer cardOffer) {
        return offerGenerationService.addNewOffer(cardOffer);
    }
}
