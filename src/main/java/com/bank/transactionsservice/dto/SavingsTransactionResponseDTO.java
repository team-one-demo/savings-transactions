package com.bank.transactionsservice.dto;

import lombok.Data;
import java.util.List;

@Data
public class SavingsTransactionResponseDTO {
    private String userId;
    private String accountNumber;
    private List<SavingsTransactionDTO> transactions;
    
    public SavingsTransactionResponseDTO() {
    }
    
    public SavingsTransactionResponseDTO(String userId, String accountNumber, List<SavingsTransactionDTO> transactions) {
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.transactions = transactions;
    }
}