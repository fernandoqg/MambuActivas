package com.Mambu.MambuActivas.domain.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountBalances {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int totalBalance;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int principalBalance;

    public int getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    public int getPrincipalBalance() {
        return principalBalance;
    }

    public void setPrincipalBalance(int principalBalance) {
        this.principalBalance = principalBalance;
    }
}
