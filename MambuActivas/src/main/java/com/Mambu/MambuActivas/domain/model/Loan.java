package com.Mambu.MambuActivas.domain.model;

import com.Mambu.MambuActivas.domain.utils.ScheduleSettings;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Loan {

    private String accountHolderKey;

    private String loanAmount;

    private String productTypeKey;

    private String notes;
    private String accountHolderType;

    private InterestSettings interestSettings;

    private ScheduleSettings scheduleSettings;

    public String getAccountHolderKey() {
        return accountHolderKey;
    }

    public void setAccountHolderKey(String accountHolderKey) {
        this.accountHolderKey = accountHolderKey;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getProductTypeKey() {
        return productTypeKey;
    }

    public void setProductTypeKey(String productTypeKey) {
        this.productTypeKey = productTypeKey;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAccountHolderType() {
        return accountHolderType;
    }

    public void setAccountHolderType(String accountHolderType) {
        this.accountHolderType = accountHolderType;
    }

    public InterestSettings getInterestSettings() {
        return interestSettings;
    }

    public void setInterestSettings(InterestSettings interestSettings) {
        this.interestSettings = interestSettings;
    }

    public ScheduleSettings getScheduleSettings() {
        return scheduleSettings;
    }

    public void setScheduleSettings(ScheduleSettings scheduleSettings) {
        this.scheduleSettings = scheduleSettings;
    }
}
