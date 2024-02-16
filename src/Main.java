import model.Book;
import model.FictionBook;
import model.Library;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library libgen = new Library();
        Scanner scanner = new Scanner(System.in);
        InputHelper helper = new InputHelper();

        while (true) {
            System.out.println("Choose a feature:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Display all books");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. List All Patrons");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = 5;
            // Read user input
            if (!scanner.hasNextInt()) {
                while (true) {
                if (scanner.hasNextInt()) {
                    System.out.println("chosie");
                    choice = scanner.nextInt();
                    break;
                } else {
                    System.out.print("Invalid input. Please enter a number: ");
                    // Consume the invalid input token
                    scanner.next();
                }
            }
        } else
                choice = scanner.nextInt();
        System.out.println(choice);
            // Perform actions based on user choice
            switch (choice) {
                case 1: {
                    String title = InputHelper.getInput("title");
                    String author = InputHelper.getInput("author");
                    String type = InputHelper.getInput("type");
                    libgen.addBook(title, author, type);
                }
                    break;
                case 2: {
                    String title = InputHelper.getInput("title");
                    libgen.removeBook(title);
                }
                    break;
                case 3: {
                    String title = InputHelper.getInput("title");
                    libgen.searchForBook(title);
                }
                    break;
                case 4:
                    libgen.listAllBooks();
                    break;
                case 5: {
                    String patronName = InputHelper.getInput("patronName");
                    String bookName = InputHelper.getInput("bookName");
                    libgen.patronBorrowBook(patronName, bookName);
                    break;
                }
                case 6: {
                    String patronName = InputHelper.getInput("patronName");
                    String bookName = InputHelper.getInput("bookName");
                    libgen.patronReturnBook(patronName, bookName);
                    break;
                }
                case 7:
                    libgen.listAllPatrons();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
//    }
    }
}