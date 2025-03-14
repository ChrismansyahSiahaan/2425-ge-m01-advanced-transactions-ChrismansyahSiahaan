package fintech.driver;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * @author 12S23003_Chrismansyah Siahaan
 * @author 12S23015_Kevin Kristoforus Samosir
 */

 public class Driver1 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         Map<String, Account> accounts = new HashMap<>();
 
         while (scanner.hasNextLine()) {
             String line = scanner.nextLine();
             if (line.equals("---")) break;
 
             String[] parts = line.split("#");
             String command = parts[0];
 
             switch (command) {
                 case "create-account":
                     String name = parts[1];
                     String id = parts[2];
                     accounts.put(id, new Account(name, id));
                     break;
                 case "create-transaction":
                     String accountId = parts[1];
                     double amount = Double.parseDouble(parts[2]);
                     String timestamp = parts[3];
                     String description = parts[4];

                 case "show-account":
                     String showId = parts[1];
                     if (accounts.containsKey(showId)) {
                         accounts.get(showId).showAccount();
                     }
                     break;
             }
         }
         scanner.close();
     }
 
 }
 