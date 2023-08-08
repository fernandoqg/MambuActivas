package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.AppovedLoanResponseDTO;
import com.Mambu.MambuActivas.domain.model.ApproveLoan;

public interface ApproveLoanService {

    AppovedLoanResponseDTO approve(ApproveLoan approveLoan, String loanAccountId);
}
