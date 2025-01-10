import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadingWords {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("Lesson20_Example/poem.txt");
        Scanner in = new Scanner(inputFile);
        // change delimiter
        in.useDelimiter("[^A-Za-z0-9]+");
        int count = 0;
        while (in.hasNext()) {
            String word = in.next();
            System.out.println(word);
            count++;
        }
        System.out.printf("%d words were scanned in.%n", count);
        in.close();
    }
}
