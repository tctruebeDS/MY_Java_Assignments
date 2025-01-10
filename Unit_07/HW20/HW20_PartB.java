package HW20;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// Theodore Truebe
// HW 20 Part B
public class HW20_PartB {
    public static void main(String[] args) throws FileNotFoundException {
        // Gets input file
        File inputFile = new File("HW20/characters.txt");
        Scanner in = new Scanner(inputFile);
        // sets delimiter so it gets characters
        in.useDelimiter("");
        // sets counters to type int
        int count = 0;
        int letters = 0;
        int numbers = 0;
        // counts everything
        while (in.hasNext()) {
            char c = in.next().charAt(0);
            System.out.print(c);
            if (Character.isLetter(c)) {
                letters++;
            } else if (Character.isDigit(c)) {
                numbers++;
            }
            count++;
        }
        // formatted output
        System.out.printf("count = %d%n", count);
        System.out.printf("letters = %d%n", letters);
        System.out.printf("digits = %d%n", numbers);
        // closes scanner
        in.close();
    }
}
