package com.capital.offergenerationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CardOffer {

    @Id
    private Long id;
    private Long RequiredCreditScore;
    private Long requiredIncome;
    private Boolean requiresNoBadCredit;
    private String offerBonus;



}
