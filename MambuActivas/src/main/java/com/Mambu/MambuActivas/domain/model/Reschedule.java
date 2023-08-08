package com.Mambu.MambuActivas.domain.model;

import com.Mambu.MambuActivas.domain.utils.LoanAccount;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reschedule {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LoanAccount loanAccount;

    public LoanAccount getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(LoanAccount loanAccount) {
        this.loanAccount = loanAccount;
    }

}
