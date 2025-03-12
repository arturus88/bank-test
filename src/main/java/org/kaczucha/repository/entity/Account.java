package org.kaczucha.repository.entity;
//129
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @SequenceGenerator(name = "stu_seq", sequenceName = "ACCOUNTS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_seq")
    @Column(name = "ACCOUNT_ID")
    private long id;
    @Column(name = "BALANCE")
    private double balance;
    @Column(name = "CURRENCY")
    private String currency;

    public Account(double balance, String currency) {
        this.balance = balance;
        this.currency = currency;
    }
}
