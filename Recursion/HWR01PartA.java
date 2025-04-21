// Theodore Truebe
// HW R01 Part A
// I mean, it works?
public class HWR01PartA {
    public static int printInverted(int n) {
        for (int i = 0; i < n; i ++) {
            System.out.print("*");
        }
        System.out.println();
        
        if (n == 1) {
            return 1;
        } else {
            return printInverted(n - 1);
        }
        
    }

    public static void main(String[] args) {
        printInverted(5);
    }

}
