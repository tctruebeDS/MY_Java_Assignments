package meStuff;

import meStuff.random;

public class newCard {
    
    public static String card;

    public static int randRank() {
        int intRank = random.rnd(13);
        return intRank;
    }

    public static int randSuit() {
        int intSuit = random.rnd(4);
        return intSuit;
    }

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
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12),
        KING(13);

        private int rank;

        private Rank(int rank) {
            this.rank = rank;
        }

        public int getRank() {
            return rank;
        }

    }

    
    
    // private member variables
    private Suit suit;
    private Rank rank;

    public newCard() {
        int s = randSuit();
        switch (s) {
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

        int r = randRank();
        switch (r) {
            case 1:
                rank = Rank.ACE;
                break;
            case 2:
                rank = Rank.TWO;
                break;
            case 3:
                rank = Rank.THREE;
                break;
            case 4:
                rank = Rank.FOUR;
                break;
            case 5:
                rank = Rank.FIVE;
                break;
            case 6:
                rank = Rank.SIX;
                break;
            case 7:
                rank = Rank.SEVEN;
                break;
            case 8:
                rank = Rank.EIGHT;
                break;
            case 9:
                rank = Rank.NINE;
                break;
            case 10:
                rank = Rank.TEN;
                break;
            case 11:
                rank = Rank.JACK;
                break;
            case 12:
                rank = Rank.QUEEN;
                break;
            case 13:
                rank = Rank.KING;
                break;

        }

    }
    // overridden constructor

    public newCard(Suit newSuit, Rank newRank) {
        suit = newSuit;
        rank = newRank;
    }
    // public methods

    public Suit getSuit(int intRank) {
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
        switch (this.suit) {
            case SPADES:
                face = "S";
                break;
            case HEARTS:
                face = "H";
                break;
            case CLUBS:
                face = "C";
                break;
            case DIAMONDS:
                face = "D";
                break;
        }
        return face;
    }

    public String printCard(){
        return getRnk() + getFace();
    }
    public String fullCard;
    // public String printCard(){
    //     String face = getRnk(2);
    //     String suit = getFace(2);
    //     fullCard = face+suit;
    //     return fullCard;
        
  //  }
    
    

    public static void main(String[] args) {
        
        
    }
}
