package me.dgpr;

public class TransferHistory {
    private long id;
    private String fromBankCode;
    private String fromBankAccountNumber;
    private String toBankCode;
    private String toBankAccountNumber;
    private long amount;

    public TransferHistory(long id, String fromBankCode, String fromBankAccountNumber, String toBankCode,
                           String toBankAccountNumber, long amount) {
        this.id = id;
        this.fromBankCode = fromBankCode;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankCode = toBankCode;
        this.toBankAccountNumber = toBankAccountNumber;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }
}

