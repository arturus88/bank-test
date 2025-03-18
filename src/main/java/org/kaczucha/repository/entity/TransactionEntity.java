package org.kaczucha.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
//113
@Data
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTIONS")
@Builder
@AllArgsConstructor
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTION_ID")
    private long id;
    @Column(name = "AMOUNT")
    private double amount;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "TRANSACTION_DATE")
    private OffsetDateTime transactionDate;
    @Column(name = "FROM_ACCOUNT_ID")
    private long fromAccountId;
    @Column(name = "TO_ACCOUNT_ID")
    private long toAccountId;

}
