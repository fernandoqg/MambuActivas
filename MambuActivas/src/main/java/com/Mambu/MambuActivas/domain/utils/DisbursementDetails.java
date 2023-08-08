package com.Mambu.MambuActivas.domain.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

public class DisbursementDetails {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String expectedDisbursementDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String firstRepaymentDate;

    public String getExpectedDisbursementDate() {
        return expectedDisbursementDate;
    }

    public void setExpectedDisbursementDate(String expectedDisbursementDate) {
        this.expectedDisbursementDate = expectedDisbursementDate;
    }

    public String getFirstRepaymentDate() {
        return firstRepaymentDate;
    }

    public void setFirstRepaymentDate(String firstRepaymentDate) {
        this.firstRepaymentDate = firstRepaymentDate;
    }
}
