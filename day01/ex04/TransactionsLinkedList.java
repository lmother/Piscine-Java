package day01.ex04;

public class TransactionsLinkedList implements TransactionsList {
    private Node    head;
    private Node    last;
    private Integer size;

    private class Node {
        private Node prev;
        private Transaction val;
        private Node next;
        public Node (Node prev, Transaction val, Node next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    @Override
    public Integer addTransaction(Transaction val) {
        Node tmp = this.last;
        Node newNode = new Node(tmp, val, null);
        this.last = newNode;
        if (head == null) {
            this.head = newNode;
            this.size = 0;
        }
        else
            tmp.next = newNode;
        this.size++;
        return 0;
    }

    @Override
    public Integer removeTransactionById(String id) {
        if (head == null)
            return -1;
        for (Node tmp = head; tmp != null; tmp = tmp.next) {
            if (tmp.val.getId().equals(id)){
                removeNode(tmp);
                return 0;
            }
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        if (head == null)
                return null;
        Transaction[] arr = new Transaction[this.size];
        int i = 0;
        for (Node tmp = head; tmp != null; tmp = tmp.next){
            arr[i] = tmp.val;
            i++;
        }
        return arr;
    }

    private void removeNode(Node n) {
        if (n == null)
            return;
        Node prev = n.prev;
        Node next = n.next;
        if (prev == null)
            this.head = next;
        else{
            prev.next = next;
            n.prev = null;
        }
        if (next == null)
            this.last = prev;
        else{
            next.prev = prev;
            n.next = null;
        }
        n.val = null;
        this.size--;
    }
    public class TransactionNotFoundException extends RuntimeException{}
}
