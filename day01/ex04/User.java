package day01.ex04;

public class User {
    private String  name;
    private Integer balance;
    private Integer id;
    private TransactionsList transactions;

    public User(){
        this.id = UserIdsGenerator.getInstance().generatedId();
    }

    public User(String name, Integer balance) {
        this.name = name;
        setBalance(balance);
        this.id = UserIdsGenerator.getInstance().generatedId();
        transactions = new TransactionsLinkedList();
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

    public TransactionsList getTransactions() { return transactions; }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Integer balance) {
        if (balance < 0) {
            System.out.println("-- Error. Balance should not be negative! --");
        }
        else
            this.balance = balance;
    }
}
