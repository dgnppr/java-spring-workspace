package me.dgpr;


public interface BankPort {
    long getBalance(String bankCode, String accountNumber);

    Result deposit(String bankCode, String accountNumber, long amount);

    record Result(String resultCode, String message) {

        public boolean isSuccess() {
            return this.resultCode.equals("success");
        }
    }
}
