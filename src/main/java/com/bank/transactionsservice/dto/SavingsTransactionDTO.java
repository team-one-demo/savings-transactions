package com.bank.transactionsservice.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SavingsTransactionDTO {
    private LocalDate date;
    private String description;
    private String type;
    private String amount;
    private String balance;
}
