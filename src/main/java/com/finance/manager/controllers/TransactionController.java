package com.finance.manager.controller;

import com.finance.manager.dto.TransactionDto;
import com.finance.manager.model.Transaction;
import com.finance.manager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction addTransaction(@RequestBody TransactionDto dto) {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return transactionService.addTransaction(dto, userEmail);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return transactionService.getAllTransactions(userEmail);
    }
}
