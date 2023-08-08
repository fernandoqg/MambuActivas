package com.Mambu.MambuActivas.domain.service;

import com.Mambu.MambuActivas.domain.dto.RescheduleResponseDTO;
import com.Mambu.MambuActivas.domain.model.Reschedule;

public interface RescheduleService {

    RescheduleResponseDTO reschedule(Reschedule reschedule, String loanAccountId);
}
