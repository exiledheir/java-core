package lesson03.secondHalf;

import lesson03.secondHalf.entities.Account;
import lesson03.secondHalf.entities.Fighter;
import lesson03.secondHalf.entities.Product;
import lesson03.secondHalf.service.BankSystem;
import lesson03.secondHalf.service.OnlineStore;
import lesson03.secondHalf.service.StreetFighter;

public class Main {

    public static void main(String[] args) {
//        OnlineStore and Product CLASS TEST
        System.out.println("**********ONLINE STORE********");
        OnlineStore store = new OnlineStore();

        store.addProduct(new Product(1, "product1", 1200, 5));
        store.addProduct(new Product(2, "product2", 792, 3));
        store.addProduct(new Product(3, "product3", 144, 0));

        System.out.println("All products");
        store.printAllProducts();

        System.out.println("Test buying product1");
        store.buyProduct(1);
        store.printAllProducts();

        System.out.println("Test buying product2 many times");
        store.buyProduct(2);
        store.buyProduct(2);
        store.buyProduct(2);
        store.buyProduct(2);
        store.printAllProducts();

        System.out.println("Not existing product");
        store.buyProduct(4);

//        BankSystem and Account CLASS TEST
        System.out.println("\n\n**********BANK SYSTEM*******");
        BankSystem bank = new BankSystem();

        Account acc1 = new Account("1", "account1", 500);
        Account acc2 = new Account("2", "account2", 1000);
        Account acc3 = new Account("3", "account3", 200);

        bank.addAccount(acc1);
        bank.addAccount(acc2);
        bank.addAccount(acc3);

        System.out.println("All accounts");
        bank.printAllAccounts();

        System.out.println("Replenish account1 for 300");
        bank.replenishAccount("1", 300);
        bank.printAllAccounts();

        System.out.println("Transfer from account2 to account3 amount 400");
        bank.transferMoneyBetweenAccounts("2", "3", 400);
        bank.printAllAccounts();

        System.out.println("Transfer more money than account1 have 2000");
        bank.transferMoneyBetweenAccounts("1", "2", 2000);
        bank.printAllAccounts();

        System.out.println("Delete account3");
        bank.deleteAccount("3");
        bank.printAllAccounts();


//        StreetFighter and Fighter CLASS TEST
        System.out.println("\n\n**********STREET FIGHTER********");
        StreetFighter streetFight = new StreetFighter();

        Fighter f1 = new Fighter(1, "fighter1", 100, 20);
        Fighter f2 = new Fighter(2, "fighter2", 100, 18);
        Fighter f3 = new Fighter(3, "fighter3", 120, 15);

        streetFight.addFighter(f1);
        streetFight.addFighter(f2);
        streetFight.addFighter(f3);

        System.out.println("All fighters");
        streetFight.printAllFighters();

        System.out.println("First fight");
        streetFight.fight(1, 2);

        System.out.println("Second fight");
        streetFight.fight(2, 3);

        System.out.println("Third fight");
        streetFight.fight(1, 3);

        System.out.println("All fighters");
        streetFight.printAllFighters();

    }
}
