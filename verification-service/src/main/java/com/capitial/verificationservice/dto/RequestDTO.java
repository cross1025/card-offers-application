package com.capitial.verificationservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String receivedCreditScore;
    private Integer last4SSN;
    private String phoneNumber;
    private String providerSource;
    private String annualIncome;
    private Boolean employed;
    private Double debtToIncomeRatio;
    private Boolean priorCapitalCredit;

}
