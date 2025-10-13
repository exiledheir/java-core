package lesson03.firstHalf.service;

import lesson03.firstHalf.entities.Book;

public class Library {

    private Book[] books = new Book[16];
    private int current = 0;

    public Book[] getBooks() {
        Book[] valid = new Book[current];

        for (int i = 0; i < current; i++) {
            valid[i] = books[i];
        }
        return valid;
    }

    public void addNewBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cant be null");

        if (current >= books.length) {
            Book[] newBooks = new Book[books.length * 2];
            for (int i = 0; i < current; i++) {
                newBooks[i] = books[i];
            }
            books = newBooks;
        }
        books[current++] = book;
    }

    public void printAllBooks() {
        for (int i = 0; i < current; i++) {
            System.out.println(books[i].getBookInfo());
        }
    }
}
