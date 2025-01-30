import Mow.Yard;
import Mow.Mower;
import java.util.Scanner;

public class mowTest {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void delay(long mseconds) {
        try {
            Thread.sleep(mseconds);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the height of the yard: ");
        Yard.rows = in.nextInt();
        System.out.print("Enter the width of the yard: ");
        Yard.columns = in.nextInt();
       
        Yard yard = new Yard(Yard.rows + 2, Yard.columns + 2);
        clearScreen();
        
        yard.mowerGoSpiral(yard.yardArray);

        in.close();
    }
}
