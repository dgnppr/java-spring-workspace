package me.dgpr;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// 은행 계좌
public record BankAccount(
        String accountNumber,
        String bankCode,
        String accountHolderName,
        BigDecimal balance,
        String currency,
        String accountType,
        String branchCode,
        String country,
        LocalDateTime createdAt
) {

}
