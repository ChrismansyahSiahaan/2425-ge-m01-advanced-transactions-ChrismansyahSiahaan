package fintech.model;

/**
 * @author 12S23003_Chrismansyah T. Siahaan
 * @author 12S23015_Kevin Kristoforus Samosir 
 */
public class Account {
    private String owner;
    private String accountName;
    private double balance;


    public Account(String owner, String accountName){
        this.owner = owner;
        this.accountName = accountName;
        this.balance = 0.0;
    }

    public String getOwner(){
        return owner;
    }
    public String getAccounName(){
        return accountName;
    }
    public double getBalance(){
        return balance;
    }

@Override
public String toString(){
    return accountName + "|" + owner + "|" + balance;
}
}