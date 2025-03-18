package org.kaczucha.controller.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionRequest {
    private double amount;
    private String currency;
    private long fromAccountId;
    private long toAccountId;

}
