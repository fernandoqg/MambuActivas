package com.Mambu.MambuActivas.domain.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleSettings {

    private int gracePeriod;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int repaymentInstallments;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int repaymentPeriodCount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String repaymentPeriodUnit;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private BillingCycleDays billingCycleDays;

    private String productTypeKey;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PenaltySettings penaltySettings;

    public String getProductTypeKey() {
        return productTypeKey;
    }

    public void setProductTypeKey(String productTypeKey) {
        this.productTypeKey = productTypeKey;
    }

    public PenaltySettings getPenaltySettings() {
        return penaltySettings;
    }

    public void setPenaltySettings(PenaltySettings penaltySettings) {
        this.penaltySettings = penaltySettings;
    }

    public BillingCycleDays getBillingCycleDays() {
        return billingCycleDays;
    }

    public void setBillingCycleDays(BillingCycleDays billingCycleDays) {
        this.billingCycleDays = billingCycleDays;
    }

    public int getGracePeriod() {
        return gracePeriod;
    }

    public void setGracePeriod(int gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    public int getRepaymentInstallments() {
        return repaymentInstallments;
    }

    public void setRepaymentInstallments(int repaymentInstallments) {
        this.repaymentInstallments = repaymentInstallments;
    }

    public int getRepaymentPeriodCount() {
        return repaymentPeriodCount;
    }

    public void setRepaymentPeriodCount(int repaymentPeriodCount) {
        this.repaymentPeriodCount = repaymentPeriodCount;
    }

    public String getRepaymentPeriodUnit() {
        return repaymentPeriodUnit;
    }

    public void setRepaymentPeriodUnit(String repaymentPeriodUnit) {
        this.repaymentPeriodUnit = repaymentPeriodUnit;
    }
}
