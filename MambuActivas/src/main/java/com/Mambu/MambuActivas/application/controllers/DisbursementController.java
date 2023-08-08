package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.ClientCreateResponseDTO;
import com.Mambu.MambuActivas.domain.dto.DisbursementResponseDTO;
import com.Mambu.MambuActivas.domain.model.Client;
import com.Mambu.MambuActivas.domain.model.Disbursement;
import com.Mambu.MambuActivas.domain.service.ClientService;
import com.Mambu.MambuActivas.domain.service.DisbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class DisbursementController {

    @Autowired
    private DisbursementService disbursementService;

    @PostMapping("/{loanAccountId}/disbursement")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Disbursement> disbursement(@RequestBody Disbursement disbursement, @PathVariable String loanAccountId){

        DisbursementResponseDTO responseDTO = disbursementService.disbursement(disbursement,loanAccountId);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        System.out.println(responseDTO.getType());
        return responseEntity;
    }
}
