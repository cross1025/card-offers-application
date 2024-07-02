package com.capital.offergenerationservice.service;

import com.capital.offergenerationservice.dto.OffersFromVerificationDTO;
import com.capital.offergenerationservice.entity.CardOffer;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface OfferGenerationService{

    public ResponseEntity<CardOffer> addNewOffer(CardOffer cardOffer);

    public ResponseEntity<String> calculateAvailableOffers(OffersFromVerificationDTO offersFromVerificationDTO);

}
