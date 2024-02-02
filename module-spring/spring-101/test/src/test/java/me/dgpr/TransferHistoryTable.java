package me.dgpr;

import java.util.HashMap;

public class TransferHistoryTable {

    private static final HashMap<Long, TransferHistory> historyTable = new HashMap<>();

    public static void insert(TransferHistory transferHistory) {
        historyTable.put(transferHistory.getId(), transferHistory);
    }

    public static TransferHistory findById(long id) {
        return historyTable.get(id);
    }
}
