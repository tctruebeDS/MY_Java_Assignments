// Theodore Truebe
// HW R01 Part B
// I mean, it works?
public class HWR01PartB {
    public static int y = 1;
    public static int printTriangle(int n) {
        if (y != n+1) {

            for (int i = 0; i < y; i++) {
                System.out.print("*");
            }
            System.out.println();
            y++;
            return printTriangle(n);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        printTriangle(5);
    }

}
