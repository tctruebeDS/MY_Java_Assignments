import java.util.Arrays;

public class SquareArray {
    public static void squares(double[] values){
        for (int i = 0; i < values.length; i ++){
            // square each element
            values[i] = Math.pow(values[i], 2);

        }
    }
    public static void main(String[] args) {
        double[] ar = { 1.0, 2.0, 3.0};
        System.out.println("Before: " + Arrays.toString(ar));
        squares(ar);
        System.out.println("After: " + Arrays.toString(ar));
    }
}
