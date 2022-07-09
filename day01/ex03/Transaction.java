package day01.ex03;
import java.util.UUID;

public class Transaction {
    private String id;
    private User inCome;
    private User outCome;
    private TransferCategory category;
    private Integer amount;

    public Transaction(UUID id, User inCome, User outCome, TransferCategory category, Integer amount) {
        this.id = id.toString();
        this.inCome = inCome;
        this.outCome = outCome;
        this.category = category;
        setAmount(amount);
    }

    public String getId(){
        return id;
    }

    public User getInCome(){
        return inCome;
    }

    public User getOutCome(){
        return outCome;
    }

    public TransferCategory getCategory(){
        return category;
    }

    public Integer getAmount(){
        return amount;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setInCome(User inCome){
        this.inCome = inCome;
    }

    public void setOutCome(User outCome){
        this.outCome = outCome;
    }

    public void setCategory(TransferCategory category){
        this.category = category;
    }

    public void setAmount(Integer amount){
        if (category.equals(TransferCategory.OUT) && amount > 0)
            System.out.println("-- Error. Amount should not be positive --");
        else if (category.equals(TransferCategory.IN) && amount < 0)
            System.out.println("-- Error. Amount should not be negative --");
        else
            this.amount = amount;
    }

    public enum TransferCategory {
        IN, OUT
    }
}
