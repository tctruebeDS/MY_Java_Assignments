package Lesson22_Example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lesson22_Example {

    public static void main(String[] args) {
        // Using a try catch statement to try and open a file for reading
        Scanner inKeyboard = new Scanner(System.in);
        boolean fileOpened = false;
        String name = "missing.txt";
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
            } catch (FileNotFoundException exception) {
                System.out.println("Error: unable to find the file named \"" + name + "\".");
                System.out.print("Enter the correct name of the file to open: ");
                name = inKeyboard.nextLine();
            }
        }
        inKeyboard.close();

    }

}
