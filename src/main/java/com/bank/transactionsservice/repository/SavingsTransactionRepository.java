package com.bank.transactionsservice.repository;

import com.bank.transactionsservice.model.SavingsTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SavingsTransactionRepository extends JpaRepository<SavingsTransaction, Long> {
    List<SavingsTransaction> findByUserIdAndAccountNumberOrderByDateDesc(String userId, String accountNumber);
}