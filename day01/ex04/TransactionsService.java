package day01.ex04;

import java.util.UUID;

public class TransactionsService {
    private final UsersList list;
    private final TransactionsLinkedList log;
    private final TransactionsLinkedList nonPair;

    TransactionsService(){
        list = new UsersArrayList();
        log = new TransactionsLinkedList();
        nonPair = new TransactionsLinkedList();
    }

    public void addUser(User user) {
        list.addUser(user);
    }

    public Integer getUserBalance(Integer id) throws Exception {
        return list.getUserById(id).getBalance();
    }

    public void doTransaction(Integer idSender, Integer idRecipient, Integer amount) throws Exception {
        User sender = list.getUserById(idSender);
        User recipient = list.getUserById(idRecipient);
        if (amount == null || amount == 0 || idSender == null ||
                idRecipient == null || sender == null || recipient == null)
                return;
        if ((list.getUserById(idSender).getBalance() - amount) < amount || amount < 0)
            throw new IllegalTransactionException();
        UUID id = UUID.randomUUID();

        Transaction out = new Transaction(id, sender, recipient, Transaction.TransferCategory.OUT, (amount * -1));
        sender.setBalance(sender.getBalance() - amount);
        sender.getTransactions().addTransaction(out);
        log.addTransaction(out);

        Transaction in = new Transaction(id, recipient, sender, Transaction.TransferCategory.IN, amount);
        recipient.setBalance(recipient.getBalance() + amount);
        recipient.getTransactions().addTransaction(in);
        log.addTransaction(in);
    }

    public Transaction [] getUserTransactions(Integer id) throws Exception {
        return list.getUserById(id).getTransactions().toArray();
    }

    public void removeUserTransaction(Integer uId, String tId) throws Exception {
        list.getUserById(uId).getTransactions().removeTransactionById(tId);
        for (int i = 0; i < list.getNumberOfUsers(); i++) {
                Transaction [] tmp = list.getUserByIndex(i).getTransactions().toArray();
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j].getId().equals(tId)){
                    nonPair.addTransaction(tmp[j]);
                }
            }
        }
    }

    public Transaction [] checkValidOfTransactions() throws Exception {
        return nonPair.toArray();
    }

    public class IllegalTransactionException extends RuntimeException {}
}
