package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.LoanCreateResponseDTO;
import com.Mambu.MambuActivas.domain.model.Loan;

public interface LoanService {

    LoanCreateResponseDTO createLoan(Loan loan);
}
