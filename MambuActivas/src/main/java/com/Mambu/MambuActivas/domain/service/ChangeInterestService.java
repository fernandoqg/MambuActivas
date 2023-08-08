package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.ChangeInterestResponseDTO;
import com.Mambu.MambuActivas.domain.model.ChangeInterestRate;

public interface ChangeInterestService {

    ChangeInterestResponseDTO change(ChangeInterestRate changeInterestRate, String loanAccountId);

}
