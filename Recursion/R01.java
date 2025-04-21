public class R01 {

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater than or equal to 0.");
        }
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }
    public static void doFactorial(int n) {
        System.out.printf("%d! = %d%n",n, factorial(n));
    }

    public static void main(String[] args) {
        doFactorial(3);
        doFactorial(5);

    }
}