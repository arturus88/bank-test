package org.kaczucha.service;

import org.kaczucha.controller.dto.ClientRequest;
import org.kaczucha.controller.dto.ClientResponse;
import org.kaczucha.repository.ClientRepository;
import org.kaczucha.repository.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper mapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }


    public void save(ClientRequest clientRequest) {
        Client client=mapper.map(clientRequest);

        clientRepository.save(client);
    }

    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public ClientResponse findResponseByEmail(String email) {
        Client client = findByEmail(email);
        return mapper.map(client);
    }


//    public void withdraw(
//            final String email,
//            final double amount) {
//        validateAmount(amount);
//        if (Objects.isNull(email)) {
//            throw new IllegalArgumentException("Email cant be null!");
//        }
//        final String lowerCaseEmail = email.toLowerCase();
//        final Client client = findByEmail(lowerCaseEmail);
//        if (amount > client.getBalance()) {
//            throw new NoSufficientFundsException("Balance must be higher or equal then amount!");
//        }
//        final double newBalance = client.getBalance() - amount;
//        client.setBalance(newBalance);
//        clientRepository.save(client);
//    }
//
//    private void validateAmount(double amount) {
//        if (amount <= 0) {
//            throw new IllegalArgumentException("Amount must be positive!");
//        }
//    }
}
