package com.Mambu.MambuActivas.application.controllers;

import com.Mambu.MambuActivas.domain.dto.ProductResponseDTO;
import com.Mambu.MambuActivas.domain.service.ClientService;
import com.Mambu.MambuActivas.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loanproducts")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/{idProducto}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createClient(@PathVariable String idProducto){

        System.out.println("idProducto: "+ idProducto);
        ProductResponseDTO responseDTO = productService.productResponse(idProducto);
        ResponseEntity responseEntity = new ResponseEntity(responseDTO, responseDTO.getStatusCode());
        System.out.println(responseDTO.getName());
        return responseEntity;
    }

}
