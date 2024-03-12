/**
 * code-defender
 * @author Griffin Ryan (glryan@uw.edu)
 * @author Tony Le ()
 **/
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        PasswordManager passwordManager = new PasswordManager();
        FileProcessor fileProcessor = new FileProcessor();

        System.out.println("Welcome to code-defender, by Griffin Ryan and Tony Le!");

        // User input collection process for names and integers
        String firstName = inputHandler.readValidName(scanner, "first name");
        String lastName = inputHandler.readValidName(scanner, "last name");
        int firstInt = inputHandler.readIntValue(scanner, "Enter the first integer: ");
        int secondInt = inputHandler.readIntValue(scanner, "Enter the second integer: ");

        scanner.nextLine(); // Consume any leftover newline

        // Informing about the default input file and asking for the input file name
        System.out.println("A default 'input.txt' file is available for use. You may also specify another file.");
        // Assuming inputFileName and inputFileExtension are already defined
        // Loop for input file name validation including existence check and regex validation
        String inputFileName = "";
        String inputFileExtension = "";
        File inputFile;
        do {
            System.out.println("Enter the name of the input file you wish to use (including extension):");
            inputFileName = scanner.nextLine();
            inputFileExtension = getFileExtension(inputFileName);
            inputFile = new File(inputFileName);

            if (!inputFile.exists()) {
                System.out.println("The input file does not exist. Please enter a different file name.");
            } else if (!inputFileName.matches("^[\\w,\\s-]+\\.[\\w]+$")) { // Example regex for file name validation
                System.out.println("Invalid file name format. Please ensure the file name is correct and try again:");
                inputFileName = ""; // Reset to trigger the loop if needed
            }
        } while (inputFileName.isEmpty() || !inputFile.exists());

        // Loop for output file name ensuring it does not exist and matches the input file's extension
        String outputFileName = "";
        File outputFile;
        do {
            System.out.println("Enter the name of the output file (must have the same extension '" + inputFileExtension + "'):");
            outputFileName = scanner.nextLine();
            outputFile = new File(outputFileName);

            if (!outputFileName.endsWith(inputFileExtension)) {
                System.out.println("The output file must have the same extension ('" + inputFileExtension + "') as the input file.");
            } else if (outputFile.exists()) {
                System.out.println("This file already exists. Please enter a different file name.");
            }
        } while (!outputFileName.endsWith(inputFileExtension) || outputFile.exists());

        fileProcessor.copyFileToNewFile(inputFileName, outputFileName);

        // Password setup and verification remains unchanged
        passwordManager.handlePasswordSetup(scanner);

        System.out.println("All operations completed successfully.");

        scanner.close();
    }

    // Utility method to extract the file extension from a file name
    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex); // includes the dot
        }
        return ""; // No extension found
    }
}
