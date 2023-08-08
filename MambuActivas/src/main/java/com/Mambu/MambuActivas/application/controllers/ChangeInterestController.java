package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.AppovedLoanResponseDTO;
import com.Mambu.MambuActivas.domain.dto.ChangeInterestResponseDTO;
import com.Mambu.MambuActivas.domain.model.ApproveLoan;
import com.Mambu.MambuActivas.domain.model.ChangeInterestRate;
import com.Mambu.MambuActivas.domain.service.ApproveLoanService;
import com.Mambu.MambuActivas.domain.service.ChangeInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/changeInterest")
public class ChangeInterestController {

    @Autowired
    private ChangeInterestService changeInterestService;

    @PostMapping("/{loanAccountId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> changeInterest(@RequestBody ChangeInterestRate changeInterestRate, @PathVariable String loanAccountId){

        System.out.println("idProducto: "+ loanAccountId);
        ChangeInterestResponseDTO responseDTO = changeInterestService.change(changeInterestRate,loanAccountId);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        //ResponseEntity responseEntity = new ResponseEntity(loanAccountId, HttpStatus.OK);
        System.out.println(responseDTO.getNotes());
        return responseEntity;
}

}