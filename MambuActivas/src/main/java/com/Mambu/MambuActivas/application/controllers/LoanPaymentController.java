package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.DisbursementResponseDTO;
import com.Mambu.MambuActivas.domain.dto.LoanPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.model.Client;
import com.Mambu.MambuActivas.domain.model.Disbursement;
import com.Mambu.MambuActivas.domain.model.LoanPayment;
import com.Mambu.MambuActivas.domain.service.DisbursementService;
import com.Mambu.MambuActivas.domain.service.LoanPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanPaymentController {

    @Autowired
    private LoanPaymentService loanPaymentService;

    @PostMapping("/{loanAccountId}/repayment")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LoanPayment> payment(@RequestBody LoanPayment loanPayment, @PathVariable String loanAccountId){

        LoanPaymentResponseDTO responseDTO = loanPaymentService.payment(loanPayment,loanAccountId);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        System.out.println(responseDTO.getType());
        return responseEntity;
    }
}
