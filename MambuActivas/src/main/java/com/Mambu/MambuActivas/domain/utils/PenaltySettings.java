package com.Mambu.MambuActivas.domain.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PenaltySettings{

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int penaltyRate;

    public int getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(int penaltyRate) {
        this.penaltyRate = penaltyRate;
    }
}
