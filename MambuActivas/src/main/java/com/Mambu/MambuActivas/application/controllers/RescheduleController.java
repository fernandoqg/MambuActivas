package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.RefinanceResponseDTO;
import com.Mambu.MambuActivas.domain.dto.RescheduleResponseDTO;
import com.Mambu.MambuActivas.domain.model.Refinance;
import com.Mambu.MambuActivas.domain.model.Reschedule;
import com.Mambu.MambuActivas.domain.service.RefinanceService;
import com.Mambu.MambuActivas.domain.service.RescheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reschedule")
public class RescheduleController {

    @Autowired
    private RescheduleService rescheduleService;

    @PostMapping("/{loanAccountId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reschedule> refinance(@RequestBody Reschedule reschedule, @PathVariable String loanAccountId){

        RescheduleResponseDTO responseDTO = rescheduleService.reschedule(reschedule,loanAccountId);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        //System.out.println(responseDTO.getNotes());
        return responseEntity;
    }
}

