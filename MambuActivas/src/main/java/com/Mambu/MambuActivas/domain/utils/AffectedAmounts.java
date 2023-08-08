package com.Mambu.MambuActivas.domain.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AffectedAmounts {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int principalAmount;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int interestAmount;

    public int getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(int principalAmount) {
        this.principalAmount = principalAmount;
    }

    public int getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(int interestAmount) {
        this.interestAmount = interestAmount;
    }
}
