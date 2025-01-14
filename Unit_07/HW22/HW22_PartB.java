package HW22;

// Theodore Truebe
// HW 22 Part B
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HW22_PartB {
    public static void main(String[] args) {
        // Gets an input file

        try {
            File inputFile = new File("HW22/birthyears.txt");
            Scanner in = new Scanner(inputFile);
            while (in.hasNextLine()) {
                Scanner lineScanner = new Scanner(in.nextLine());
                lineScanner.useDelimiter("[,.\s\t\n\r]+");
                String name = lineScanner.next();
                String word = lineScanner.next();
                Integer birthYear = 0;
                // Deals with the N/A
                try {
                    birthYear = Integer.parseInt(word);
                    System.out.printf("%s was born in %d.%n", name, birthYear);
                } catch (NumberFormatException exception) {
                    System.out.printf(
                            "I do not know when %s was born because they are incompitent and doesn't know how to put all of their information in a document.%n",
                            name);
                }

                lineScanner.close();

            }
            in.close();
            // Deals with other exceptions
        } catch (FileNotFoundException exception) {
            System.out.println("File not found!");
        } catch (Exception exception) {
            System.err.print("An error occurred: ");
            System.err.println(exception.getMessage());
            exception.printStackTrace();
        }

    }

}
