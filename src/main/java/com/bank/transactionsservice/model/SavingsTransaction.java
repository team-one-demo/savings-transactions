package com.bank.transactionsservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class SavingsTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String userId;
    private String accountNumber;
    private LocalDate date;
    private String description;
    private String type;
    private BigDecimal amount;
    private BigDecimal balance;
}
