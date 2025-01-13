package meStuff;

public class random {
    public static int rnd(int max){
        // generates a random integer from 1 to max
        double r = Math.random() * max;
        int nr = (int) r + 1;
        return nr;
    }
    
}
