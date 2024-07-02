package com.capital.ingestionservice.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class IngestionRequestDTO {

    private Long ingestionId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Integer receivedCreditScore;
    private Integer last4SSN;
    private String phoneNumber;
    private String providerSource;
    private String annualIncome;
    private Boolean employed;
    private Double debtToIncomeRatio;
    private Boolean priorCapitalCredit;

}
