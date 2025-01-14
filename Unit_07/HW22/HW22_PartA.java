package HW22;

// Theodore Truebe
// HW 22 Part A
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HW22_PartA {
    public static void main(String[] args) {
        Scanner inKeyboard = new Scanner(System.in);
        boolean fileOpened = false;
        String name;
        // Asks for the file name
        System.out.print("Enter the correct name of the file to open: ");
        name = inKeyboard.nextLine();
        // Tries inputting the file that the user inputted and when there is not already an opened file
        while (fileOpened == false) {
            try {
                File inputFile = new File(name);
                Scanner in = new Scanner(inputFile);
                while (in.hasNext()) {
                    String word = in.next();
                    System.out.println(word);
                }
                in.close();
                fileOpened = true;
                
                // Asks for a different file name if the user put a bad file in 
            } catch (FileNotFoundException exception) {
                System.err.println("Error: unable to find the file named \"" + name + "\".");
                System.err.print("Enter the correct name of the file to open or # to quit: ");
                name = inKeyboard.nextLine();
                if (name.contains("#")) {
                    System.out.println("Goodbye");
                    break;
                }
            }
        }
        inKeyboard.close();

    }

}
