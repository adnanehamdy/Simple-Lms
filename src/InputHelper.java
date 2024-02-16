import java.util.Scanner;

public class InputHelper {
    static Scanner scanner;
    InputHelper()
    {
        InputHelper.scanner = new Scanner(System.in);
    }
    public static String getInput(String name) {
        while (true) {
            System.out.print("enter the " + name + " : ");
            if (scanner.hasNext()) {
                return scanner.next();
            } else {
                System.out.print("Invalid input. Please enter a String: ");
                // Consume the invalid input token
                scanner.next();
            }
        }
    }

}
