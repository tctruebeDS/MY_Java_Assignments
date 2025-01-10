
// Theodore Truebe
// HW21 Part B
// IMPORTS
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HW21_PartB {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("HW21/sales_by_cat.txt");
        Scanner in = new Scanner(inputFile);
        // MAIN STRING
        // finds expense, dept, and manager and formatted outputs them
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[,\s\r\n]+");
            String dept = lineScanner.next();
            String manager = lineScanner.next();
            Double expense;
            if (lineScanner.hasNextDouble()) {
                expense = lineScanner.nextDouble();
            } else {
                // skip over the "n/a"
                lineScanner.next();
                expense = 0.0;
            }
            System.out.printf("%-17s | %-10s | $%10.2f%n", dept, manager, expense);
            lineScanner.close();
        }

        in.close();
    }
}
