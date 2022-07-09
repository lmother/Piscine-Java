package day01.ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Node head;
    private Node tail;
    private Integer size;


    private class Node {
        private Transaction val;
        private Node next;
        private Node prev;
        public Node (Transaction val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public void addTransaction(Transaction transaction) {

    }

    @Override
    public void removeTransactionById(UUID id) {

    }

    @Override
    public Transaction[] toArray() {
        return new Transaction[0];
    }
}
