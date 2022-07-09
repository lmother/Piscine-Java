package day01.ex04;

interface TransactionsList {
    Integer addTransaction(Transaction val);
    Integer removeTransactionById(String id);
    Transaction[] toArray();

}
