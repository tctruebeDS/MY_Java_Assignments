import java.util.Arrays;

public class TaleOfTwoB {
    public static void multiply(double[] values, double factor) {
        for (int i = 0; i < values.length; i++) {
            values[i] = values[i] * factor;
        }
    }

    public static void main(String[] args) {
        double[] scores = { 32, 54, 67.5, 29, 35 };
        System.out.println("Scores: " + Arrays.toString(scores));
        multiply(scores, 10);
        System.out.println("Scores: " + Arrays.toString(scores));
    }
}
