
/*Theodore Truebe
 * AT Unit 05 project- Card class
 */
import java.util.Scanner;

public class Card {
    // enum Suit...
    // enum Rank...
    // constructor
    // Card()
    private static String input;
    // defines the different card suits
    static String heart;
    static String spade;
    static String diamond;
    static String club;

    // private static void newRandSuit() {
    // suitRandom = (int) Math.random() * 4;
    // }

    public enum Suit {

        DIAMONDS(1),
        CLUBS(2),
        HEARTS(3),
        SPADES(4);

        private int suit;

        private Suit(int suit) {

            this.suit = suit;
        }

        public int getSuit() {

            return suit;
        }
    }

    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13),
        ACE(14);

        Rank(int i) {

        }

    }

    // private member variables
    private Suit suit;
    private Rank rank;

    // constructor
    public Card() {
        // make all cards Q of Hearts
        int r = randomInt(4);
        switch (r) {
            case 1:
                suit = Suit.DIAMONDS;
                break;
            case 2:
                suit = Suit.CLUBS;
                break;
            case 3:
                suit = Suit.HEARTS;
                break;
            case 4:
                suit = Suit.SPADES;
                break;
        }
        // randomize rank
        r = randomInt(13);
        switch (r) {
            case 1:
                rank = Rank.TWO;
                break;
            case 2:
                rank = Rank.THREE;
                break;
            case 3:
                rank = Rank.FOUR;
                break;
            case 4:
                rank = Rank.FIVE;
                break;
            case 5:
                rank = Rank.SIX;
                break;
            case 6:
                rank = Rank.SEVEN;
                break;
            case 7:
                rank = Rank.EIGHT;
                break;
            case 8:
                rank = Rank.NINE;
                break;
            case 9:
                rank = Rank.TEN;
                break;
            case 10:
                rank = Rank.JACK;
                break;
            case 11:
                rank = Rank.QUEEN;
                break;
            case 12:
                rank = Rank.KING;
                break;
            case 13:
                rank = Rank.ACE;
                break;

        }
    }

    // overridden constructor
    public Card(Suit newSuit, Rank newRank) {
        suit = newSuit;
        rank = newRank;
    }
    // public methods

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;

    }

    public String getRnk() {
        String rnk = "";
        switch (rank) {
            case TWO:
                rnk = "2";
                break;
            case THREE:
                rnk = "3";
                break;
            case FOUR:
                rnk = "4";
                break;
            case FIVE:
                rnk = "5";
                break;
            case SIX:
                rnk = "6";
                break;
            case SEVEN:
                rnk = "7";
                break;
            case EIGHT:
                rnk = "8";
                break;
            case NINE:
                rnk = "9";
                break;
            case TEN:
                rnk = "T";
                break;
            case JACK:
                rnk = "J";
                break;
            case QUEEN:
                rnk = "Q";
                break;
            case KING:
                rnk = "K";
                break;
            case ACE:
                rnk = "A";
                break;

        }
        return rnk;
    }

    public String getFace() {
        String face = "";
        switch (suit) {
            case SPADES:
                face = spade;
                break;
            case HEARTS:
                face = heart;
                break;
            case CLUBS:
                face = club;
                break;
            case DIAMONDS:
                face = spade;
                break;
        }
        return face;
    }
    // helper methods

    // helper method to get random int from 1 to upper value=
    private static int randomInt(int upper) {
        double r = Math.random() * upper;
        int i = (int) r + 1;
        return i;

    }

    // makes it so windows users don't just get ?s
    public static boolean wSuit;

    public static void windows() {
        if (input.equals("yes") || input.equals("y")) {
            wSuit = true;
        } else if (input.equals("no") || input.equals("n")) {
            wSuit = false;
        } else {
            System.err.println("Error");
            return;
        }
        if (wSuit == true) {
            heart = "H";
            spade = "S";
            diamond = "D";
            club = "C";
        } else {
            heart = "♥";
            spade = "♠";
            diamond = "♦";
            club = "♣";
        }
    }

    // main method- used to test card
    public static void main(String[] args) {
        Card c = new Card();
        Scanner in = new Scanner(System.in);

        System.out.print("Are you using a windows machine? Y = Yes, N = No: ");
        input = in.nextLine();
        input = input.toLowerCase();
        windows();
        // randomize suit

        System.out.println("Suit = " + c.getSuit());
        System.out.println("Rank = " + c.getRank());
        Card q = new Card(Suit.HEARTS, Rank.QUEEN);
        System.out.println(q.getRnk() + q.getFace());
        in.close();
    }
}