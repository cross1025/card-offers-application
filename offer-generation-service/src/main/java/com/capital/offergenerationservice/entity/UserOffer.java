package com.capital.offergenerationservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class UserOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Integer receivedCreditScore;
    private Integer last4SSN;
    private String phoneNumber;
    private String providerSource;
    private Long annualIncome;
    private Boolean employed;
    private Double debtToIncomeRatio;
    private Boolean priorBadCapitalCredit;
    @OneToMany
    private List<CardOffer> cardOffersList;
}
