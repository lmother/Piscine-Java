package day01.ex03;

import java.util.UUID;

public class Program {
    public static void print(Transaction [] tr) {
        for (int i = 0; i < tr.length; i++)
            System.out.println(tr[i].getId());
    }

    public static void main(String[] args) {

        User out = new User("Out", 200);

        out.getTransactions().removeTransactionById("ewrwerwrer");

        Transaction t1 = new Transaction(UUID.randomUUID(), out,
                new User("Sam", 500), Transaction.TransferCategory.OUT, -100);
        Transaction t2 = new Transaction(UUID.randomUUID(), out,
                new User("Sam", 500), Transaction.TransferCategory.OUT, -100);
        Transaction t3 = new Transaction(UUID.randomUUID(), out,
                new User("Sam", 500), Transaction.TransferCategory.OUT, -100);
        Transaction t4 = new Transaction(UUID.randomUUID(), out,
                new User("Sam", 500), Transaction.TransferCategory.OUT, -100);
        Transaction t5 = new Transaction(UUID.randomUUID(), out,
                new User("Sam", 500), Transaction.TransferCategory.OUT, -100);

        Transaction t6 = new Transaction(UUID.randomUUID(), out,
                new User("Sam", 500), Transaction.TransferCategory.OUT, -100);

        out.getTransactions().addTransaction(t1);
        out.getTransactions().addTransaction(t2);
        out.getTransactions().addTransaction(t3);
        out.getTransactions().addTransaction(t4);
        out.getTransactions().addTransaction(t5);


        out.getTransactions().toArray();


        print(out.getTransactions().toArray());
        System.out.println("---------------- After remove 1 ---------------");
        try {
            out.getTransactions().removeTransactionById(t6.getId());
        }
        catch (Exception ex){
            System.out.printf("Error. Transaction < %s > not found!!!\n", t6.getId());
        }

        out.getTransactions().removeTransactionById(t2.getId());
        print(out.getTransactions().toArray());
        System.out.println("---------------- After remove 2 ---------------");
        out.getTransactions().removeTransactionById(t1.getId());
        print(out.getTransactions().toArray());
    }
}
