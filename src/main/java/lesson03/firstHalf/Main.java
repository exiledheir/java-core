package lesson03.firstHalf;

import lesson03.firstHalf.entities.BankAccount;
import lesson03.firstHalf.entities.Book;
import lesson03.firstHalf.entities.Car;
import lesson03.firstHalf.service.Library;
import lesson03.firstHalf.entities.Person;
import lesson03.firstHalf.entities.Rectangle;
import lesson03.firstHalf.entities.enums.Status;


public class Main {
    public static void main(String[] args) {
//        Person CLASS TEST
        System.out.println("**********PERSON********");
        Person person = new Person("Test", 10);
        person.introduce();

//        Rectangle CLASS TEST
        System.out.println("\n\n**********RECTANGLE********");
        Rectangle rectangle = new Rectangle(10, 20);

        double p = rectangle.calculatePerimeter();
        System.out.println("Perimeter of rectangle: " + p);

        double s = rectangle.calculateSquare();
        System.out.println("Square of rectangle: " + s);

//        Car CLASS TEST
        System.out.println("\n\n**********CAR********");
        Car car = new Car("Tashkent", "Toyota", 2020);

        car.printCarInfo();

//        BankAccount CLASS TEST
        System.out.println("\n\n**********BANK ACCOUNT********");
        BankAccount bankAccount = new BankAccount("Test", "123456", 100);

        System.out.println(bankAccount);

        bankAccount.deposit(43);
        System.out.println("Current balance: " + bankAccount.getBalance());
        bankAccount.withdrawal(11);
        System.out.println("Current balance after withdrawal: " + bankAccount.getBalance());


//        Library and Book CLASS TEST
        System.out.println("\n\n**********LIBRARY AND BOOK********");
        Library library = new Library();
        Book book1 = new Book("111", "Test1", "Author1", 2000, Status.AVAILABLE);
        Book book2 = new Book("222", "Test2", "Author2", 2008, Status.RESERVED);

        library.addNewBook(book1);
        library.addNewBook(book2);

        System.out.println("Before reserving");
        library.printAllBooks();
        book1.reserveBook();
        System.out.println("After reserving:");
        library.printAllBooks();


    }
}
