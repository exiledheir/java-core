package lesson03.firstHalf.entities;

public class BankAccount {
    private final String fio;
    private final String accountNumber;
    private double balance;

    public BankAccount(String fio, String accountNumber, double balance) {
        if (fio == null || fio.isBlank()) {
            throw new IllegalArgumentException("Enter valid fio");
        }
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Enter valid account number");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Enter valid balance amount");
        }
        this.fio = fio;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("");
        }
        balance += amount;
    }

    public boolean withdrawal(double amount) {
        if (amount <= 0 || amount > balance) return false;

        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
            "fio='" + fio + '\'' +
            ", accountNumber='" + accountNumber + '\'' +
            ", balance=" + balance +
            '}';
    }
}