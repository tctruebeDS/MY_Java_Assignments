import zoo.*;
public class InheritDemo {
    public static void main(String[] args) {
        Bovine bessy = new Bovine ("Bessy", 1100);
        bessy.feedHay(100);
        System.out.println("Pounds of hay = " + bessy.getHayConsumed());
        bessy.printInfo();
    }
}
