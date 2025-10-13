package lesson03.secondHalf.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private final String accountNumber;
    private final String fio;
    private double balance;

    public Account(String accountNumber, String fio, double balance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Enter valid account number");
        }
        if (fio == null || fio.isBlank()) {
            throw new IllegalArgumentException("Enter valid fio");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Enter valid balance amount");
        }
        this.fio = fio;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountInfo() {
        return "Account{" + "accountNumber='" + accountNumber + '\'' + ", fio='" + fio + '\'' + ", balance=" + balance + '}';
    }

    public void replenish(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Enter valid amount to replenish");

        this.balance += amount;
    }

    public boolean withdrawal(double amount) {
        if (amount <= 0 || amount > balance) return false;

        balance -= amount;
        return true;
    }

}
