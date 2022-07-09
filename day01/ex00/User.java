package day01.ex00;

public class User {
    private String  name;
    private Integer balance;
    private Integer id;

    public User(){}

    public User (String name, Integer balance, Integer id) {
        this.name = name;
        setBalance(balance);
        this.id = id;
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

    public void setId(Integer id) {
        this.id = id;
    }
}
