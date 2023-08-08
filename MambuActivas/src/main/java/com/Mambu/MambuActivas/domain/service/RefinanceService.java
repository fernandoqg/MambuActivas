package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.RefinanceResponseDTO;
import com.Mambu.MambuActivas.domain.model.Refinance;

public interface RefinanceService {

    RefinanceResponseDTO refinance(Refinance refinance, String loanAccountId);
}
