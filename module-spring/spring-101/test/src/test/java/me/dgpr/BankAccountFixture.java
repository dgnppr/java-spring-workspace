package me.dgpr;

public enum BankAccountFixture {

    INSTANCE("1234567890", "123");

    private final String accountNumber;
    private final String bankCode;

    BankAccountFixture(String accountNumber, String bankCode) {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
    }

    public BankAccount createBankAccount() {
        return BankAccountFactory.createBankAccount(accountNumber, bankCode);
    }
}
