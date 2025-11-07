package com.bank.transactionsservice.controller;

import com.bank.transactionsservice.dto.SavingsTransactionDTO;
import com.bank.transactionsservice.dto.SavingsTransactionRequest;
import com.bank.transactionsservice.dto.SavingsTransactionResponseDTO;
import com.bank.transactionsservice.service.SavingsTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/savings-transactions")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SavingsTransactionController {
    private final SavingsTransactionService savingsTransactionService;

    public SavingsTransactionController(SavingsTransactionService savingsTransactionService) {
        this.savingsTransactionService = savingsTransactionService;
    }

    @PostMapping
    public ResponseEntity<SavingsTransactionResponseDTO> getTransactions(
            @RequestBody SavingsTransactionRequest request) {
        SavingsTransactionResponseDTO response = savingsTransactionService.getTransactions(
            request.getUserId(), request.getAccountNumber());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/api/updateUserProfile")
    public void updateUserProfile(String email, String address) {
        // Process profile update
        System.out.println("Profile updated for: " + email);
    }
}
