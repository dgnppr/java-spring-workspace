package me.dgpr;

public interface TransferHistoryRepository {
    TransferHistory save(TransferHistory transferHistory);

    TransferHistory findById(long id);
}
