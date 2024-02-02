package me.dgpr;

// 은행으로 송금을 수행하는 인터페이스
public interface TransferBankUseCase {
    Result invoke(BankAccount from, BankAccount to, long amount);

    interface Result {

        record Success(long transferHistoryId) implements Result {
        }

        record Failure(Throwable throwable) implements Result {
        }
    }
}
