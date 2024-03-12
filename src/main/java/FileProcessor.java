/**
 * code-defender
 * @author Griffin Ryan (glryan@uw.edu)
 * @author Tony Le ()
 **/
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileProcessor {
    private PrintWriter writer;

    /**
     * Copies the content of an input file to a new output file.
     * Assumes checks for file existence and extension validation are handled externally.
     * @param inputFilePath the path to the source file.
     * @param outputFilePath the path to the destination file.
     */
    public void copyFileToNewFile(String inputFilePath, String outputFilePath) {
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        try {
            Files.copy(inputFile.toPath(), outputFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File has been successfully copied to " + outputFilePath);
        } catch (IOException e) {
            System.err.println("An error occurred while copying the file: " + e.getMessage());
        }
    }

}
