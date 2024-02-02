package me.dgpr;

public final class BankAccountFactory {

    public static BankAccount createBankAccount(String accountNumber, String bankCode) {
        return new BankAccount(accountNumber,
                bankCode,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }
}
