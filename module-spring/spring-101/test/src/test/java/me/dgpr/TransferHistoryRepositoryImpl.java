package me.dgpr;

public class TransferHistoryRepositoryImpl implements TransferHistoryRepository {

    @Override
    public TransferHistory save(TransferHistory transferHistory) {
        TransferHistoryTable.insert(transferHistory);
        return transferHistory;
    }

    @Override
    public TransferHistory findById(long id) {
        return TransferHistoryTable.findById(id);
    }
}
