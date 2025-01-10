
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
// Theodore Truebe 
// HW21 Part A
public class HW21_PartA {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("HW21/Top5Unemployment.txt");
        Scanner in = new Scanner(inputFile);
        System.out.printf(
                "-----------------------------------------------------------------%n                    Top 5 Unemployment Rates%n-----------------------------------------------------------------%n");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[,\n]+");
            String name = lineScanner.next().trim();
            String nextWord = lineScanner.next().trim();
            double percentage = Double.valueOf(nextWord);
            nextWord = lineScanner.next().trim();
            int rank = Integer.valueOf(nextWord);
            
            String region = lineScanner.next().trim();

            System.out.printf("Ranked #%3d: %-18s| %6.2f %% | %s %n",
                    rank, name, percentage, region);
            lineScanner.close();
        }
        
        System.out.printf("-----------------------------------------------------------------%n");
        in.close();
        
    }
}
