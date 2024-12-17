package myStuff.util;

public class Random {
    public static int getRandomInteger(int upper){
        // generates a random integer from 1 to upper
        double r = Math.random()* upper;
        int val = (int)r+1;
        return val; 
    }
}
