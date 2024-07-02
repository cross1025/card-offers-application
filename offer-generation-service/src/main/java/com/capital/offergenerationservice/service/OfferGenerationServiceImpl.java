package com.capital.offergenerationservice.service;

import com.capital.offergenerationservice.dto.OffersFromVerificationDTO;
import com.capital.offergenerationservice.entity.CardOffer;
import com.capital.offergenerationservice.entity.UserOffer;
import com.capital.offergenerationservice.repo.CardOfferRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfferGenerationServiceImpl implements OfferGenerationService {

    private final CardOfferRepository cardOfferRepository;
    private final ObjectMapper objectMapper;

    public ResponseEntity<String> calculateAvailableOffers(OffersFromVerificationDTO offersFromVerificationDTO) {

        UserOffer userOffer = new UserOffer();
        userOfferHydration(userOffer, offersFromVerificationDTO);
        List<CardOffer> cardOfferList = new ArrayList<>();
        userOffer.setCardOffersList(cardOfferList);
        for(CardOffer cardOffer : cardOfferRepository.findAll()) {
            if(criteriaCheck(offersFromVerificationDTO, cardOffer)) {
                userOffer.getCardOffersList().add(cardOffer);
            }
        }
        try {
            String userOfferJson = objectMapper.writeValueAsString(userOffer);
            return ResponseEntity.ok().body(userOfferJson);
        } catch (JsonProcessingException e) {
            System.out.println("Error processing json");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There was an error returning userOffer");
        }


    }

    public ResponseEntity<CardOffer> addNewOffer(CardOffer cardOffer) {
        System.out.println("Processing new offer");
        cardOfferRepository.save(cardOffer);
        System.out.println("New Card Offer has been added to the database!");
        return new ResponseEntity<CardOffer>(cardOffer, HttpStatus.CREATED);

    }

    public boolean criteriaCheck(OffersFromVerificationDTO offersFromVerificationDTO, CardOffer cardOffer) {
        if(offersFromVerificationDTO.getAnnualIncome() < cardOffer.getRequiredIncome()) {
            return false;
        }
        if(offersFromVerificationDTO.getReceivedCreditScore() < cardOffer.getRequiredCreditScore()) {
            return false;
        }
        if(offersFromVerificationDTO.getPriorBadCapitalCredit() == true && cardOffer.getRequiresNoBadCredit() == true) {
            return false;
        }
        return true;
    }

    public void userOfferHydration(UserOffer userOffer, OffersFromVerificationDTO offersFromVerificationDTO) {
        Optional.ofNullable(offersFromVerificationDTO.getFirstName()).ifPresent(userOffer::setFirstName);
        Optional.ofNullable(offersFromVerificationDTO.getMiddleName()).ifPresent(userOffer::setMiddleName);
        Optional.ofNullable(offersFromVerificationDTO.getLastName()).ifPresent(userOffer::setLastName);
        Optional.ofNullable(offersFromVerificationDTO.getEmail()).ifPresent(userOffer::setEmail);
        Optional.ofNullable(offersFromVerificationDTO.getReceivedCreditScore()).ifPresent(userOffer::setReceivedCreditScore);
        Optional.ofNullable(offersFromVerificationDTO.getLast4SSN()).ifPresent(userOffer::setLast4SSN);
        Optional.ofNullable(offersFromVerificationDTO.getPhoneNumber()).ifPresent(userOffer::setPhoneNumber);
        Optional.ofNullable(offersFromVerificationDTO.getProviderSource()).ifPresent(userOffer::setProviderSource);
        Optional.ofNullable(offersFromVerificationDTO.getAnnualIncome()).ifPresent(userOffer::setAnnualIncome);
        Optional.ofNullable(offersFromVerificationDTO.getEmployed()).ifPresent(userOffer::setEmployed);
    }

}
