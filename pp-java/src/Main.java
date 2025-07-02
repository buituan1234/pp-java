import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    String isbn;
    boolean available;

    public Book(String title, String author, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + available +
                '}';
    }
}

class LibraryManager {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addBook() {
        System.out.println("Enter book details:");

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();

        books.add(new Book(title, author, isbn, true));
        System.out.println("Book added successfully!");
    }

    public void printBooks() {
        System.out.println("Book list:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void checkOutBook() {
        System.out.print("Enter the book ISBN to check out: ");
        String isbn = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                found = true;
                if (book.available) {
                    book.available = false;
                    System.out.println("Book checked out successfully!");
                } else {
                    System.out.println("Book is not available.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("No book found with the given ISBN.");
        }
    }

    public void checkInBook() {
        System.out.print("Enter the book ISBN to check in: ");
        String isbn = scanner.nextLine();

        boolean found = false;
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                found = true;
                if (!book.available) {
                    book.available = true;
                    System.out.println("Book checked in successfully!");
                } else {
                    System.out.println("Book is already available.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("No book found with the given ISBN.");
        }
    }

    public void searchBook() {
        System.out.print("Enter book title, author, or ISBN to search: ");
        String input = scanner.nextLine();
        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(input) || book.author.equalsIgnoreCase(input) || book.isbn.equals(input)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the given title, author, or ISBN.");
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Print Books");
            System.out.println("3. Check Out Book");
            System.out.println("4. Check In Book");
            System.out.println("5. Search Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    printBooks();
                    break;
                case 3:
                    checkOutBook();
                    break;
                case 4:
                    checkInBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.showMenu();
    }
}