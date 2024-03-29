/**
 * code-defender
 * @author Griffin Ryan (glryan@uw.edu)
 * @author Tony Le ()
 **/
import java.util.Scanner;

public class InputHandler {
    // Read and validate a name
    public String readValidName(Scanner scanner, String nameType) {
        System.out.println("Enter your " + nameType + " (1-50 characters, letters, apostrophes, and hyphens allowed): ");
        String input = scanner.nextLine().trim();
        while (!input.matches("^[A-Za-z'-]{1,50}$")) {
            System.out.println("Invalid input. Please try again: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    // Read and validate an integer value
    public int readIntValue(Scanner scanner, String prompt) {
        System.out.println(prompt + " (Integer value between -2,147,483,648 and 2,147,483,647): ");
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid integer. Please try again: ");
            scanner.next(); // consume the non-integer input
        }
        return scanner.nextInt();
    }

    public String readValidFileName(Scanner scanner, String expectedExtension) {
        System.out.println("Enter the name of the file (must end in " + expectedExtension + "): ");
        String fileName = scanner.nextLine().trim();
        String regexPattern = "^[\\w,\\s-]+\\." + expectedExtension + "$"; // Dynamic regex based on extension
        while (!fileName.matches(regexPattern)) {
            System.out.println("Invalid file name. Please ensure the file name ends with ." + expectedExtension + " and try again: ");
            fileName = scanner.nextLine().trim();
        }
        return fileName;
    }

}
