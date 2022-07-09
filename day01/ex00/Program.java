package day01.ex00;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User ben = new User();
        ben.setName("Ben");
        ben.setId(1);
        ben.setBalance(300);
        System.out.printf("Name user :  %s Id : %d Balance : %d\n\n",ben.getName(), ben.getId(), ben.getBalance());

        User sam = new User("Sam", 500, 2);
        System.out.printf("Name user :  %s Id : %d Balance : %d\n\n",sam.getName(), sam.getId(), sam.getBalance());

        User err = new User();
        err.setName("err");
        err.setId(3);
        err.setBalance(-30);
        System.out.printf("Name user :  %s Id : %d Balance : %d\n\n",err.getName(), err.getId(), err.getBalance());

        Transaction out = new Transaction(UUID.randomUUID(), ben, sam, Transaction.TransferCategory.OUT, -100);
        System.out.printf("%s -> %s , %d, %s, ID-%s\n\n", out.getOutCome().getName(), out.getInCome().getName(),
                out.getAmount(), out.getCategory().toString(), out.getId().toString());

        Transaction in = new Transaction(UUID.randomUUID(), sam, ben, Transaction.TransferCategory.IN, 200);
        System.out.printf("%s -> %s , %d, %s, ID-%s\n\n", in.getOutCome().getName(), in.getInCome().getName(),
                in.getAmount(), in.getCategory().toString(), in.getId().toString());


        Transaction out1 = new Transaction(UUID.randomUUID(), ben, sam, Transaction.TransferCategory.OUT, 100);
        System.out.printf("%s -> %s , %d, %s, ID-%s\n\n", out1.getOutCome().getName(), out1.getInCome().getName(),
                out1.getAmount(), out1.getCategory().toString(), out1.getId().toString());

        Transaction in1 = new Transaction(UUID.randomUUID(), sam, ben, Transaction.TransferCategory.IN, -200);
        System.out.printf("%s -> %s , %d, %s, ID-%s", in1.getOutCome().getName(), in1.getInCome().getName(),
                in1.getAmount(), in1.getCategory().toString(), in1.getId().toString());


    }
}
