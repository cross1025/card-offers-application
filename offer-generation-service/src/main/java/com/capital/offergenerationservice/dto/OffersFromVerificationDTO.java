package com.capital.offergenerationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OffersFromVerificationDTO {

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
