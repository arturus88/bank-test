package org.kaczucha.repository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
@Data
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class Client {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String name;
    @Column(name = "MAIL")
    private String email;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private List<Account> accounts;

    public Client(String name, String email, List<Account> accounts) {
        this.name = name;
        this.email = email;
        this.accounts = accounts;
    }

    public double getBalance() {
        if(!accounts.isEmpty()) {
            return accounts.get(0).getBalance();
        }
        return 0;
    }

    public void setBalance(double newBalance) {
        if(!accounts.isEmpty()){
            accounts.get(0).setBalance(newBalance);
        }
    }
}
