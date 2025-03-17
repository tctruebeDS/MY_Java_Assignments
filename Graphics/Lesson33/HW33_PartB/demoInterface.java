import java.util.ArrayList;

public class demoInterface {

    public static void main(String[] args) {
        Animal a = new Animal("Bessie", 1000);
        Measurable m = (Measurable) a;
        ArrayList<Measurable> animals = new ArrayList<>();
        animals.add(a);
        Animal b = new Animal("Bob", 1500);
        animals.add(b);
        System.out.println("Average animal weight = " + Measurable.calcAvg(animals));
        System.out.println(b.compareTo(a));
        int compareResult;
        compareResult = b.compareTo(a);
        if (compareResult==-1) {
            System.out.println("The first one is smaller than the second");
        } else if (compareResult==1) {
            System.out.println("The second one is bigger than the first one");
        } else if (compareResult==0) {
            System.out.println("They are equal");
        } else {
            System.err.println("error");
        }
    }
}