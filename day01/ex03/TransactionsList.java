package day01.ex03;

import java.util.UUID;

interface TransactionsList {
    void addTransaction(Transaction transaction);
    void removeTransactionById(UUID id);
    Transaction [] toArray();

}
