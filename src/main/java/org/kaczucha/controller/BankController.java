package org.kaczucha.controller;

import lombok.RequiredArgsConstructor;
import org.kaczucha.controller.dto.ClientRequest;
import org.kaczucha.controller.dto.ClientResponse;
import org.kaczucha.repository.entity.Client;
import org.kaczucha.service.BankService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class BankController {
    private final BankService service;

    @GetMapping(path = "/api/user")
    public ResponseEntity<ClientResponse> findByEmail(@RequestParam String email){
        ClientResponse client=service.findResponseByEmail(email);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("EXSAMPLE_HEDER","DUMMY_VALUE");
        return new ResponseEntity<>(client, httpHeaders,HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/api/user")
    @ResponseStatus(code=HttpStatus.CREATED)
    public void createClient(@RequestBody ClientRequest client){
        service.save(client);

    }

}
