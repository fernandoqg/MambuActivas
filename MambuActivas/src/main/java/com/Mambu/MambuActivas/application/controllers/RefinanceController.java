package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.FullPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.dto.RefinanceResponseDTO;
import com.Mambu.MambuActivas.domain.model.FullPayment;
import com.Mambu.MambuActivas.domain.model.Refinance;
import com.Mambu.MambuActivas.domain.service.FullPaymentService;
import com.Mambu.MambuActivas.domain.service.RefinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/refinance")
public class RefinanceController {

    @Autowired
    private RefinanceService refinanceService;

    @PostMapping("/{loanAccountId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Refinance> refinance(@RequestBody Refinance refinance, @PathVariable String loanAccountId){

        RefinanceResponseDTO responseDTO = refinanceService.refinance(refinance,loanAccountId);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        //System.out.println(responseDTO.getNotes());
        return responseEntity;
    }
}

