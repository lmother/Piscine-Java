package day01.ex04;

public class Program {

    public static void main(String[] args) throws Exception {
        TransactionsService ts = new TransactionsService();

        User sam = new User("Sam", 1000);
        User ben = new User("Ben", 505);
        User kok = new User("Kok", 444);

        ts.addUser(sam);
        ts.addUser(ben);
        ts.addUser(kok);

        System.out.printf("Balance %s : %d Id :%d\n",sam.getName(), ts.getUserBalance(sam.getId()), sam.getId());
        System.out.printf("Balance %s : %d Id :%d\n",ben.getName(), ts.getUserBalance(ben.getId()), ben.getId());
        System.out.printf("Balance %s : %d Id :%d\n",kok.getName(), ts.getUserBalance(kok.getId()), kok.getId());


        System.out.println("----- After transaction ------");
        ts.doTransaction(1, 2, 55);

        System.out.printf("Balance %s : %d Id :%d\n",sam.getName(), ts.getUserBalance(sam.getId()), sam.getId());
        System.out.printf("Balance %s : %d Id :%d\n",ben.getName(), ts.getUserBalance(ben.getId()), ben.getId());
        System.out.printf("Balance %s : %d Id :%d\n",kok.getName(), ts.getUserBalance(kok.getId()), kok.getId());

        try {
            ts.doTransaction(1, 2, -55);
        }catch (Exception ex){
            System.out.println(ex.getClass());
            System.out.println("Error. Amount no be negative");
        }

        try {
            ts.doTransaction(1, 2, 1000000);
        }catch (Exception ex){
            System.out.println(ex.getClass());
            System.out.println("Error. No money!!!!");
        }

        try {
            ts.doTransaction(4, 2, 200);
        }catch (Exception ex){
            System.out.println(ex.getClass());
        }

        System.out.printf("Balance %s : %d Id :%d\n",sam.getName(), ts.getUserBalance(sam.getId()), sam.getId());
        System.out.printf("Balance %s : %d Id :%d\n",ben.getName(), ts.getUserBalance(ben.getId()), ben.getId());
        System.out.printf("Balance %s : %d Id :%d\n",kok.getName(), ts.getUserBalance(kok.getId()), kok.getId());

        ts.doTransaction(3, 1, 26);

        System.out.println("----- After transaction 1------");

        System.out.printf("Balance %s : %d Id :%d\n",sam.getName(), ts.getUserBalance(sam.getId()), sam.getId());
        System.out.printf("Balance %s : %d Id :%d\n",ben.getName(), ts.getUserBalance(ben.getId()), ben.getId());
        System.out.printf("Balance %s : %d Id :%d\n",kok.getName(), ts.getUserBalance(kok.getId()), kok.getId());

        ts.doTransaction(1, 2, 55);
        ts.doTransaction(1, 2, 55);
        ts.doTransaction(1, 2, 55);
        ts.doTransaction(1, 2, 55);

        System.out.println("----- After transaction 2------");

        System.out.printf("Balance %s : %d Id :%d\n",sam.getName(), ts.getUserBalance(sam.getId()), sam.getId());
        System.out.printf("Balance %s : %d Id :%d\n",ben.getName(), ts.getUserBalance(ben.getId()), ben.getId());
        System.out.printf("Balance %s : %d Id :%d\n",kok.getName(), ts.getUserBalance(kok.getId()), kok.getId());

        Transaction [] trSam = sam.getTransactions().toArray();

        ts.removeUserTransaction(1, trSam[0].getId());
        ts.removeUserTransaction(1, trSam[1].getId());

        System.out.println(trSam[0].getId());
        System.out.println(trSam[1].getId());

        System.out.println("------- After delete transaction -------");

        Transaction [] valid = ts.checkValidOfTransactions();
        for (int i = 0; i < valid.length; i++) {
            System.out.println(valid[i].getId());
        }

    }
}
