package com.bank.transactionsservice.service;

import com.bank.transactionsservice.dto.SavingsTransactionDTO;
import com.bank.transactionsservice.dto.SavingsTransactionResponseDTO;
import com.bank.transactionsservice.model.SavingsTransaction;
import com.bank.transactionsservice.repository.SavingsTransactionRepository;
import org.springframework.stereotype.Service;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class SavingsTransactionService {
    private final SavingsTransactionRepository savingsTransactionRepository;
    private final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);

    public SavingsTransactionService(SavingsTransactionRepository savingsTransactionRepository) {
        this.savingsTransactionRepository = savingsTransactionRepository;
    }

    public SavingsTransactionResponseDTO getTransactions(String userId, String accountNumber) {
        List<SavingsTransaction> transactions = savingsTransactionRepository
            .findByUserIdAndAccountNumberOrderByDateDesc(userId, accountNumber);
        
        List<SavingsTransactionDTO> transactionDTOs = transactions.stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
            
        return new SavingsTransactionResponseDTO(userId, accountNumber, transactionDTOs);
    }

    private SavingsTransactionDTO convertToDTO(SavingsTransaction transaction) {
        SavingsTransactionDTO dto = new SavingsTransactionDTO();
        dto.setDate(transaction.getDate());
        dto.setDescription(transaction.getDescription());
        dto.setType(transaction.getType());
        
        // Format amount with sign
        String amount = currencyFormatter.format(transaction.getAmount().abs());
        if (transaction.getAmount().compareTo(java.math.BigDecimal.ZERO) < 0) {
            dto.setAmount("-" + amount);
        } else {
            dto.setAmount(amount);
        }
        
        // Format balance
        dto.setBalance(currencyFormatter.format(transaction.getBalance()));
        
        return dto;
    }
}