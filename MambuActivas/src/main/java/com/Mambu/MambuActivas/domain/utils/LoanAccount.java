package com.Mambu.MambuActivas.domain.utils;

import com.Mambu.MambuActivas.domain.model.InterestSettings;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanAccount {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private DisbursementDetails disbursementDetails;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private InterestSettings interestSettings;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private ScheduleSettings scheduleSettings;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int topUpAmount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String productTypeKey;


    public String getProductTypeKey() {
        return productTypeKey;
    }

    public void setProductTypeKey(String productTypeKey) {
        this.productTypeKey = productTypeKey;
    }

    public int getTopUpAmount() {
        return topUpAmount;
    }

    public void setTopUpAmount(int topUpAmount) {
        this.topUpAmount = topUpAmount;
    }

    public DisbursementDetails getDisbursementDetails() {
        return disbursementDetails;
    }

    public void setDisbursementDetails(DisbursementDetails disbursementDetails) {
        this.disbursementDetails = disbursementDetails;
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
