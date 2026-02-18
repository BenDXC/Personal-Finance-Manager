package com.finance.manager.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDto {
    private String type;
    private BigDecimal amount;
    private String category;
    private String description;
}
