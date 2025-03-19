package fintech.model;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 12S23003_Chrismansyah T. Siahaan
 * @author 12S23015_Kevin Kristoforus Samosir 
 */

 public class Account {
     private String name;
     private String username;
     private double balance;
     private List<Transaction> transactions;
 
     public Account(String name, String username) {
         this.name = name;
         this.username = username;
         this.balance = 0.0;
         this.transactions = new ArrayList<>();
     }
 
     public String getName() {
         return name;
     }
 
     public String getUsername() {
         return username;
     }
 
     public double getBalance() {
         return balance;
     }
 
     public void addTransaction(Transaction transaction) throws CustomException {
         if (transaction.getAmount() < 0 && (balance + transaction.getAmount()) < 0) {
             throw new CustomException("Transaction would result in negative balance.");
         }
         transactions.add(transaction);
         balance += transaction.getAmount();
     }
 
     public List<Transaction> getTransactions() {
         return transactions;
     }
 }