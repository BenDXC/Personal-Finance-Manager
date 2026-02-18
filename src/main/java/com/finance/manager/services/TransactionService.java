package com.finance.manager.service;

import com.finance.manager.dto.TransactionDto;
import com.finance.manager.model.Transaction;
import com.finance.manager.model.User;
import com.finance.manager.repository.TransactionRepository;
import com.finance.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;

    public Transaction addTransaction(TransactionDto dto, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        Transaction t = new Transaction();
        t.setType(dto.getType());
        t.setAmount(dto.getAmount());
        t.setCategory(dto.getCategory());
        t.setDescription(dto.getDescription());
        t.setDate(LocalDateTime.now());
        t.setUser(user);
        return transactionRepository.save(t);
    }

    public List<Transaction> getAllTransactions(String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        return transactionRepository.findByUser(user);
    }
}
