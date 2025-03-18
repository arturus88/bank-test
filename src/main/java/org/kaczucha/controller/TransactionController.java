package org.kaczucha.controller;

import lombok.RequiredArgsConstructor;
import org.kaczucha.controller.dto.TransactionRequest;
import org.kaczucha.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TransactionController {
    private TransactionService service;

    @PostMapping(path = "/api/transaction")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void   createTransaction(@RequestBody TransactionRequest request){
        service.createTransaction(request);
    }
}
