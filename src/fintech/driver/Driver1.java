package fintech.driver;
import fintech.model.Account;
import fintech.model.Transaction;
import fintech.model.CustomException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 12S23003_Chrismansyah Siahaan
 * @author 12S23015_Kevin Kristoforus Samosir
 */
 
 public class Driver1 {
     private static Map<String, Account> accounts = new HashMap<>();
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String input;
 
         while (scanner.hasNextLine()) {
             input = scanner.nextLine();
             System.out.println(input); // Print the input line
             if (input.equals("---")) {
                 printAccounts();
                 break; // Keluar dari loop jika mendeteksi '---'
             }
             String[] parts = input.split("#");
 
             switch (parts[0]) {
                 case "create-account":
                     createAccount(parts[1], parts[2]);
                     break;
                 case "create-transaction":
                     createTransaction(parts[1], Double.parseDouble(parts[2]), parts[3], parts[4]);
                     break;
                 case "show-account":
                     showAccount(parts[1]);
                     break;
                 case "show-accounts":
                     printAccounts();
                     break;
                 case "remove-account":
                     removeAccount(parts[1]);
                     break;
                 default:
                     // Tidak ada output untuk perintah yang tidak dikenal
                     break;
             }
         }
         scanner.close();
     }
 
     private static void createAccount(String name, String username) {
         accounts.put(username, new Account(name, username));
     }
 
     private static void createTransaction(String username, double amount, String date, String description) {
         Account account = accounts.get(username);
         if (account != null) {
             Transaction transaction = new Transaction(amount, date, description);
 
             try {
                 account.addTransaction(transaction);
             } catch (CustomException e) {
                 // Tidak ada output untuk transaksi yang gagal
             }
         }
     }
 
     private static void showAccount(String username) {
         Account account = accounts.get(username);
         if (account != null) {
             System.out.printf("%s|%s|%.1f%n", account.getUsername(), account.getName(), account.getBalance());
             for (Transaction transaction : account.getTransactions()) {
                 System.out.printf("%d|%s|%.1f|%s|%s%n", 
                     account.getTransactions().indexOf(transaction) + 1, 
                     account.getUsername(), 
                     transaction.getAmount(), 
                     transaction.getDate(), 
                     transaction.getDescription());
             }
         }
     }
 
     private static void printAccounts() {
         for (Account account : accounts.values()) {
             System.out.printf("%s|%s|%.1f%n", account.getUsername(), account.getName(), account.getBalance());
             for (Transaction transaction : account.getTransactions()) {
                 System.out.printf("%d|%s|%.1f|%s|%s%n", 
                     account.getTransactions().indexOf(transaction) + 1, 
                     account.getUsername(), 
                     transaction.getAmount(), 
                     transaction.getDate(), 
                     transaction.getDescription());
             }
         }
     }
 
     private static void removeAccount(String username) {
         accounts.remove(username);
     }
 }