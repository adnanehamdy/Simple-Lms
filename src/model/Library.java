package model;
import java.util.*;
import java.util.stream.IntStream;

public class Library {
    ArrayList<Book> libraryBooks;
    ArrayList<Patron> patronList;

    public Library()
    {
        libraryBooks = new ArrayList<Book>();
        patronList = new ArrayList<Patron>();
    }
    public void listAllBooks()
    {
        System.out.println("LIST_OF_BOOKS");
        for (Book libraryBook : libraryBooks) {
            System.out.println("Book Name : " + libraryBook.getTitle() + " <> available: " + libraryBook.isAvailable());
        }
    }

    public void addBook(@org.jetbrains.annotations.NotNull String titleValue,
                          @org.jetbrains.annotations.NotNull String authorValue,
                          @org.jetbrains.annotations.NotNull String type)
    {
        Book newBook = type.equals("Fiction") ? new FictionBook() : new NonFictionBook();
        newBook.setTitle(titleValue);
        newBook.setAuthor(authorValue);
        newBook.setAvailable(true);
        libraryBooks.add(newBook);
    }
    public String removeBook(@org.jetbrains.annotations.NotNull  String bookName)
    {
            if (libraryBooks.removeIf(book -> (book.getTitle().equals(bookName) && book.isAvailable())))
                return "book removed successfully";
            return "book not found";
    }
    public boolean isBookAvailable(String bookName)
    {
        Optional<Book> firstMatch = libraryBooks.stream()
                .filter(book -> book.getTitle().equals(bookName))
                .findFirst();
        firstMatch.ifPresent(book -> book.setAvailable(false));
        return (firstMatch.isPresent());
    }
    public void patronBorrowBook(@org.jetbrains.annotations.NotNull  String patronName,
                                   @org.jetbrains.annotations.NotNull  String bookName)
    {
        if (this.isBookAvailable(bookName)) {
            Optional<Patron> firstPatron = patronList.stream().filter(patron -> patron.getName().equals(patronName)).
                    findFirst();
            if (firstPatron.isEmpty()) {
                Patron patron = new Patron(patronName);
                patron.barrowBook(bookName);
                patronList.add(patron);
            }
            else {
                firstPatron.ifPresent(patron -> patron.barrowBook(bookName));
            }
        }
    }
    public void patronReturnBook(@org.jetbrains.annotations.NotNull  String patronName,
                                 @org.jetbrains.annotations.NotNull  String bookName)
    {
        patronList.removeIf(patron -> patron.getName().equals(patronName));
        Optional<Book> firstMatch = libraryBooks.stream()
                .filter(book -> book.getTitle().equals(bookName))
                .findFirst();
        firstMatch.ifPresent(book -> book.setAvailable(true));
    }
    public void listAllPatrons()
    {
        System.out.println("LIST_OF_PATRONS: ");
        for (Patron patron: patronList)
        {
            System.out.print("patron name : " + patron.getName());
            patron.showBorrowedBooks();
        }
    }
    public void searchForBook(String bookName)
    {
        Optional<Book> firstMatch = libraryBooks.stream()
                .filter(book -> book.getTitle().equals(bookName))
                .findFirst();
        if (firstMatch.isPresent())
        {firstMatch.ifPresent(Book::DisplayInfo);}
        else
            System.out.println("BOOK NOT FOUND");

    }
}
