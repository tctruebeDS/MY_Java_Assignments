package myStuff;
import myStuff.util.Random;
public class Package_Demo {
    public static void main(String[] args) {
        System.out.println("The following integer should be a random integer from 1 to 10, ");
        System.out.printf("  %d%n", Random.getRandomInteger(10));
    }
}
