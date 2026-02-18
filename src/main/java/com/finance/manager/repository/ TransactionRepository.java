package com.finance.manager.repository;

import com.finance.manager.model.Transaction;
import com.finance.manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
}
