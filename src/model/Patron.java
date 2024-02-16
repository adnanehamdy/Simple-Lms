package model;
import java.util.*;
public class Patron {
    String name;
    ArrayList<String> borrowedBooks;

    Patron(String name)
    {
        borrowedBooks = new ArrayList<String>();
        this.name = name;
    }
    public void barrowBook(String bookName)
    {
        borrowedBooks.add(bookName);
    }
    public void returnBook(String name)
    {
       borrowedBooks.removeIf(book -> (book.equals(name)));
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return (name);
    }
    public void showBorrowedBooks()
    {
        System.out.print(" , My Books : ");
        borrowedBooks.forEach(book ->System.out.print(" " + book + ", "));
        System.out.println();
    }
}
