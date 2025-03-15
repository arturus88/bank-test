package org.kaczucha.controller.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.kaczucha.repository.entity.Account;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {

    private Long id;
    private String name;
    private String email;
    private List<Long> accounts;

}
