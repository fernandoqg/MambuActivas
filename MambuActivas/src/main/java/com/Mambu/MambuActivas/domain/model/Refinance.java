package com.Mambu.MambuActivas.domain.model;

import com.Mambu.MambuActivas.domain.utils.LoanAccount;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Refinance {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LoanAccount loanAccount;


    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String productTypeKey;


    public String getProductTypeKey() {
        return productTypeKey;
    }

    public void setProductTypeKey(String productTypeKey) {
        this.productTypeKey = productTypeKey;
    }

    public LoanAccount getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(LoanAccount loanAccount) {
        this.loanAccount = loanAccount;
    }

}
