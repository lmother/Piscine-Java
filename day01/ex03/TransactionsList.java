package day01.ex03;

import java.util.UUID;

interface TransactionsList {
    Integer addTransaction(Transaction val);
    Integer removeTransactionById(String id);
    Transaction [] toArray();

}
