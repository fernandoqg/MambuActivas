package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.AppovedLoanResponseDTO;
import com.Mambu.MambuActivas.domain.dto.ProductResponseDTO;
import com.Mambu.MambuActivas.domain.model.ApproveLoan;
import com.Mambu.MambuActivas.domain.model.Client;
import com.Mambu.MambuActivas.domain.service.ApproveLoanService;
import com.Mambu.MambuActivas.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class ApproveLoanController {

    @Autowired
    private ApproveLoanService approveLoanService;

    @PostMapping("/{loanAccountId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> approveLoan(@RequestBody ApproveLoan approveLoan, @PathVariable String loanAccountId){

        AppovedLoanResponseDTO responseDTO = approveLoanService.approve(approveLoan,loanAccountId);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        System.out.println(responseDTO.getAccountState());
        return responseEntity;
    }

}