// Theodore Truebe
// HW 31 

public class BaseballCard {
    String name; // the name of the player on the card.
    int year; // the year the card was issued.

    public BaseballCard(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    // Overriden equals method
    public boolean equals(Object obj) {

        final double SMALL_NUMBER = 0.0000000000001;

        // Checks to make sure they are both baseball cards
        if (obj instanceof BaseballCard == false) {
            return false;
        }

        BaseballCard otherCard = (BaseballCard) obj;

        // Checks the info in the basball card
        if (this.name.equals(otherCard.name) && Math.abs(this.year - otherCard.year) < SMALL_NUMBER) {
            return true;
        } else {
            return false;
        }
    }
    // Overriden toString 
    public String toString() {
        return getClass().getName() + "[Name = " + name + ", Year = " + year + "]";
    }

    public static void main(String[] args) {

        // Demo program
        BaseballCard g = new BaseballCard("jef", 2030);
        BaseballCard l = new BaseballCard("jef", 2030);
        BaseballCard jef = new BaseballCard("Jim", 1996);
        if (g.equals(l)) {
            System.out.println("da same");
        } else {
            System.out.println("not da same");
        }
        if (g.equals(jef)) {
            System.out.println("Jef is Jim");
        } else {
            System.out.println("Jef is not Jim");
        }
        
        System.out.println(l.toString());
    }
}