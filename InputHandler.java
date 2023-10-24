import java.util.Scanner;
public class InputHandler {
    public int getUserInput(Scanner scanner, String prompt) {
        int userInput;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Please enter a valid number: ");
                scanner.next(); // Consume invalid input
            }
            userInput = scanner.nextInt();
        } while (userInput < 0); // Keep prompting until a positive integer is entered
        return userInput;
    }
}
