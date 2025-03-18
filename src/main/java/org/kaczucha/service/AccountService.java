package org.kaczucha.service;
//40

import lombok.RequiredArgsConstructor;
import org.kaczucha.controller.dto.AccountRequest;
import org.kaczucha.controller.dto.AccountResponse;
import org.kaczucha.repository.AccountRepository;
import org.kaczucha.repository.entity.Account;
import org.kaczucha.repository.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public AccountResponse find(Long id) {
        return repository.findById(id)
                .map(account -> AccountResponse.builder()
                        .balance(account.getBalance())
                        .currency(account.getCurrency())
                        .userId(account.getId())
                        .id(account.getId())
                        .build())
                .orElseThrow(() -> new IllegalArgumentException("Account with id: " + id));

    }

    public void save(AccountRequest account) {
        repository.save(Account.builder()
                .balance(account.getBalance())
                .currency(account.getCurrency())
                        .build());


    }

    public void transfer(
            long fromAccountId,
            long toAccountId,
            double amount
    ) {
        validateAmount(amount);
        if (fromAccountId ==toAccountId) {
            throw new IllegalArgumentException("fromAccount and toAcount cant be equal!");
        }
        Account fromAccount = repository.getOne(fromAccountId);
        Account toAccount = repository.getOne(toAccountId);

        if (fromAccount.getBalance() - amount >= 0) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
        } else {
            throw new NoSufficientFundsException("Not enough funds!");
        }
        repository.save(fromAccount);
        repository.save(toAccount);
    }

    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive!");
        }
    }


}
