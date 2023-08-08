package com.Mambu.MambuActivas.domain.utils;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingCycleDays {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int[] days;

    public int[] getDays() {
        return days;
    }

    public void setDays(int[] days) {
        this.days = days;
    }
}
