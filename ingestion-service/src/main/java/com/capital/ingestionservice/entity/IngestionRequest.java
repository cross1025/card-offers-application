package com.capital.ingestionservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class IngestionRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

}
