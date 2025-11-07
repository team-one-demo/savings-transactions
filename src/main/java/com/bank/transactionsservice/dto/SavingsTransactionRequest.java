package com.bank.transactionsservice.dto;

import lombok.Data;

@Data
public class SavingsTransactionRequest {
    private String userId;
    private String accountNumber;
}