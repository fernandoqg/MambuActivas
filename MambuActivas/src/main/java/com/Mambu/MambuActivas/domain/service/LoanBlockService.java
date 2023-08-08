package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.LoanBlockResponseDTO;
import com.Mambu.MambuActivas.domain.model.LoanBlock;

public interface LoanBlockService {

    LoanBlockResponseDTO block(LoanBlock loanBlock, String loanAccountId);
}
