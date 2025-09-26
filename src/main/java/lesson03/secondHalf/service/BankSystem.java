package lesson03.secondHalf.service;

import lesson03.secondHalf.entities.Account;

public class BankSystem {
    private Account[] accounts = new Account[16];
    private int current = 0;

    public void addAccount(Account account) {
        if (account == null) throw new IllegalArgumentException("Account cant be null");

        if (current >= accounts.length) {
            Account[] newAccount = new Account[accounts.length * 2];
            for (int i = 0; i < current; i++) {
                newAccount[i] = accounts[i];
            }
            accounts = newAccount;
        }
        accounts[current++] = account;
    }

    public boolean deleteAccount(String accountNumber) {
        for (int i = 0; i < current; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                for (int j = i; j < current - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                accounts[--current] = null;
                return true;
            }
        }
        return false;
    }

    public void replenishAccount(String accountNumber, double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Enter valid amount to replenish");

        for (int i = 0; i < current; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                accounts[i].replenish(amount);
            }
        }
    }

    public void transferMoneyBetweenAccounts(String senderAccountNumber, String receiverAccountNumber, double amount) {
        Account sender = findAccount(senderAccountNumber);
        Account receiver = findAccount(receiverAccountNumber);

        if (sender == null) throw new IllegalArgumentException("Sender not found");
        if (receiver == null) throw new IllegalArgumentException("Receiver not found");

        if (sender.withdrawal(amount)) {
            receiver.replenish(amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient funds");
        }

    }

    public void printAllAccounts() {
        for (int i = 0; i < current; i++) {
            System.out.println(accounts[i].getAccountInfo());
        }
        System.out.println();
    }

    private Account findAccount(String accountNumber) {
        for (int i = 0; i < current; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) return accounts[i];
        }
        return null;
    }
}
