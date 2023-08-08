package com.Mambu.MambuActivas.domain.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InterestSettings {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private IndexRateSettings indexRateSettings;

    private int InterestRate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String interestChargeFrequency;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String interestApplicationMethod;


    public int getInterestRate() {
        return InterestRate;
    }

    public void setInterestRate(int interestRate) {
        InterestRate = interestRate;
    }

    public IndexRateSettings getIndexRateSettings() {
        return indexRateSettings;
    }

    public void setIndexRateSettings(IndexRateSettings indexRateSettings) {
        this.indexRateSettings = indexRateSettings;
    }

    public String getInterestChargeFrequency() {
        return interestChargeFrequency;
    }

    public void setInterestChargeFrequency(String interestChargeFrequency) {
        this.interestChargeFrequency = interestChargeFrequency;
    }

    public String getInterestApplicationMethod() {
        return interestApplicationMethod;
    }

    public void setInterestApplicationMethod(String interestApplicationMethod) {
        this.interestApplicationMethod = interestApplicationMethod;
    }
}
