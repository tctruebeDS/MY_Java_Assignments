package Unit05;

public class CallMethod {
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    
    
    
        public static void main(String[] args) {
            int x = 10;
            int y = 5;
            int val = max(x, y);
            System.out.println(val);
    
            x = 2;
            y = 4;
            val = max(x, y);
            System.out.println(val);
    
            x = 3;
            y = 3;
            val = max(x, y);
            System.out.println(val);
    }
}
