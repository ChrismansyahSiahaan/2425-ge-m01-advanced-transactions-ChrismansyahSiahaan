package fintech.model;

/**
 * @author 12S23003_Chrismansyah Siahaan
 * @author 12S23015_Kevin Kristoforus Samosir
 */

public class Transaction {
    private static int transactionCounter = 0;
    private int id;
    private String accountName;
    private double amount;
    private String postedAt;
    private String note;
    private double balance;

    public Transaction(String accountName, double amount, String postedAt, String note, double balance) {
        this.id = ++transactionCounter;
        this.accountName = accountName;
        this.amount = amount;
        this.postedAt = postedAt;
        this.note = note.length() > 40 ? note.substring(0, 40) : note;
        this.balance = balance + amount;
    }
    public int getId() {
        return id;
    }
    public String getAccountName() {
        return accountName;
    }
    public double getAmount() {
        return amount;
    }
    public String getPostedAt() {
        return postedAt;
    }
    public String getNote() {
        return note;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return id + "|" + accountName + "|" + amount + "|" + postedAt + "|" + note + "|" + balance;
    }
}