package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.DisbursementResponseDTO;
import com.Mambu.MambuActivas.domain.model.Disbursement;

public interface DisbursementService {

    DisbursementResponseDTO disbursement(Disbursement disbursement, String loanAccountId);
}
