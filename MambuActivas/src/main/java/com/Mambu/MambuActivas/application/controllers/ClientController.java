package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.ClientCreateResponseDTO;
import com.Mambu.MambuActivas.domain.model.Client;
import com.Mambu.MambuActivas.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> createClient(@RequestBody Client client){

        ClientCreateResponseDTO responseDTO = clientService.createClient(client);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        System.out.println(responseDTO.getFirstName()+" "+ responseDTO.getLastName());
        return responseEntity;
    }

}
