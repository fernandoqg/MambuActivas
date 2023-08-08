package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.LoanPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.model.LoanPayment;

public interface LoanPaymentService {

    LoanPaymentResponseDTO payment(LoanPayment loanPayment, String loanAccountId);
}
