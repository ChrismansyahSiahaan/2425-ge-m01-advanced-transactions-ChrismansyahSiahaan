package fintech.model;

/**
* @author 12S23003_Chrismansyah Siahaan
* @author 12S23015_Kevin Kristoforus Samosir
*/

public class Transaction {
    private double amount;
    private String date; // Menggunakan String untuk menyimpan tanggal
    private String description;

    public Transaction(double amount, String date, String description) {
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date; // Mengembalikan tanggal sebagai String
    }

    public String getDescription() {
        return description;
    }
}