package lesson03.firstHalf.entities;

import lesson03.firstHalf.entities.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Book {
    private final String isbn;
    private final String name;
    private final String author;
    private final int year;

    private Status status;

    public Book(String isbn, String name, String author, int year, Status status) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("Enter valid isbn number");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Enter valid book name");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Enter valid author name");
        }
        if (status == null) {
            throw new IllegalArgumentException("Enter valid status");
        }

        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.year = year;
        this.status = status;
    }

    public String getBookInfo() {
        return "Book{" + "isbn='" + isbn + '\'' + ", name='" + name + '\'' + ", author='" + author + '\'' + ", year=" + year + ", status=" + status + '}';
    }

    public void reserveBook() {
        if (this.status == Status.RESERVED) throw new IllegalArgumentException("Book already Reserved");
        this.setStatus(Status.RESERVED);
    }
}
