package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.FullPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.model.FullPayment;

public interface FullPaymentService {

    FullPaymentResponseDTO payment(FullPayment fullPayment, String loanAccountId);
}
