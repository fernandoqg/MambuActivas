package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.LoanBlockResponseDTO;
import com.Mambu.MambuActivas.domain.dto.LoanPaymentResponseDTO;
import com.Mambu.MambuActivas.domain.model.LoanBlock;
import com.Mambu.MambuActivas.domain.model.LoanPayment;
import com.Mambu.MambuActivas.domain.service.LoanBlockService;
import com.Mambu.MambuActivas.domain.service.LoanPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanBlockController {

    @Autowired
    private LoanBlockService loanBlockService;

    @PostMapping("/{loanAccountId}/lock")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LoanBlock> block(@RequestBody LoanBlock loanBlock, @PathVariable String loanAccountId){

        LoanBlockResponseDTO responseDTO = loanBlockService.block(loanBlock,loanAccountId);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        System.out.println(responseDTO.getNotes());
        return responseEntity;
    }
}

