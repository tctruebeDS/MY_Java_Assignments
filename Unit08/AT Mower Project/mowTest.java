import Mow.Yard;
import java.util.Scanner;

public class mowTest {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the height of the yard: ");
        Yard.rows = in.nextInt();
        System.out.print("Enter the width of the yard: ");
        Yard.columns = in.nextInt();
        Yard yard = new Yard(Yard.rows + 2, Yard.columns + 2);
        clearScreen();
        yard.printYard(yard.yardArray);
        yard.mowSpot(1, 1);
        clearScreen();
        yard.printYard(yard.yardArray);
        System.out.println(yard.getYardHeight());
        System.out.println(yard.getYardWidth());
    }
}
