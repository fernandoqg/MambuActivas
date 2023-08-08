package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.DisbursementResponseDTO;
import com.Mambu.MambuActivas.domain.dto.FullPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.model.Disbursement;
import com.Mambu.MambuActivas.domain.model.FullPayment;
import com.Mambu.MambuActivas.domain.service.DisbursementService;
import com.Mambu.MambuActivas.domain.service.FullPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payOff")
public class FullPaymentController {

    @Autowired
    private FullPaymentService fullPaymentService;

    @PostMapping("/{loanAccountId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FullPayment> fullPayment(@RequestBody FullPayment fullPayment, @PathVariable String loanAccountId){

        FullPaymentResponseDTO responseDTO = fullPaymentService.payment(fullPayment,loanAccountId);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);
        //System.out.println(responseDTO.getNotes());
        return responseEntity;
    }
}

