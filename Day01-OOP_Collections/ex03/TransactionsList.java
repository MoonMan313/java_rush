import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction elementNew);

    void removeTransactionById(UUID id);

    Transaction[] transformToArray();
}
