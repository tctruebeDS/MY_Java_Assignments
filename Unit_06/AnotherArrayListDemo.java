import java.util.ArrayList;

public class AnotherArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Emily");
        names.add("Bob");
        names.add("Cindy");
        names.add("Jim");
        System.out.println(names);
        names.remove(1);
        System.out.println(names);
        System.out.println(names.get(1));
        names.add(1,"Schmit");
        int i = 0;
        names.remove(i);
        System.out.println(names);
        }

}
