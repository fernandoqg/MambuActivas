package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.ClientCreateResponseDTO;
import com.Mambu.MambuActivas.domain.dto.LoanCreateResponseDTO;
import com.Mambu.MambuActivas.domain.model.Client;
import com.Mambu.MambuActivas.domain.model.Loan;
import com.Mambu.MambuActivas.domain.service.ClientService;
import com.Mambu.MambuActivas.domain.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan){

        LoanCreateResponseDTO responseDTO = loanService.createLoan(loan);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        System.out.println(responseDTO.getId()+" "+responseDTO.getLoanAmount()+" "+responseDTO.getAccountState());
        return responseEntity;
    }
}
