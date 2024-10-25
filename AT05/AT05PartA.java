package AT05;

/*
* Theodore Truebe
* AT05 HW Part A
*/
import java.util.Random;

public class AT05PartA {

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 100; i += 1) {
            int num = rand.nextInt(0, 100);
            System.out.println(num);
        }
    }
}
