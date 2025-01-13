
import java.util.Scanner;

import meStuff.newCard;

import meStuff.random;

import java.util.ArrayList;

public class Blackjack {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String input;
    public static String comparee;

    public static boolean compare() {
        if (input.equalsIgnoreCase(comparee)) {
            return true;
        } else {
            return false;
        }
    }

    public static void printHand(ArrayList whichHand) {
        System.out.println((whichHand.get(whichHand.size() - 1)));

    }

    public static int index;
    public static int handScore;
    public static int addend;
    public static boolean ten = false;
    public static int aceInt;
    public static String c;
    public static ArrayList<String> playersHand = new ArrayList<>();
    public static ArrayList<String> dealersHand = new ArrayList<>();

    public static int ace() {
        int aceInt = 11;
        if (handScore + 11 > 21) {
            aceInt = 1;

        }
        return aceInt;
    }

    public static void handTotal(ArrayList whichHand) {

        // newCard card = new newCard();
        // String c = card.printCard();
        handScore = 0;
        int handSize = whichHand.size();
        for (int i = 0; i < handSize; i++) {
            String r = c.substring(0, 1);
            switch (r) {
                case "2":
                    handScore += 2;
                    break;
                case "3":
                    handScore += 3;
                    break;
                case "4":
                    handScore += 4;
                    break;
                case "5":
                    handScore += 5;
                    break;
                case "6":
                    handScore += 6;
                    break;
                case "7":
                    handScore += 7;
                    break;
                case "8":
                    handScore += 8;
                    break;
                case "9":
                    handScore += 9;
                    break;
                case "10":
                    handScore += 10;
                    break;
                case "J":
                    handScore += 10;
                    break;
                case "Q":
                    handScore += 10;
                    break;
                case "K":
                    handScore += 10;
                    break;
                case "A":
                    ace();
                    break;
            }

        }

    }

    // MAIN GAME SETUP
    public static boolean stillGoing;
    public static boolean playerBust;
    public static boolean dealerStands;
    public static String DHString;
    public static String PHString;
    public static int ds;
    public static int ps;

    public static void setup() {
        clearScreen();
        stillGoing = true;
        playerBust = false;
        playersHand.clear();
        dealersHand.clear();
        c = card.printCard();
        playersHand.add(c);
        newCard card = new newCard();
        c = card.printCard();
        dealersHand.add(c);

        ds = 0;
        ps = 0;

    }

    // Prints what the player can see of the dealer's hand
    public static String printDH() {
        dTotal();
        if (ds > 10) {
            DHString = "";
            for (int i = 0; i < dealersHand.size(); i++) {
                DHString = DHString + "[" + dealersHand.get(i) + "]";
            }
        } else {
            DHString = "";
            DHString = DHString + "[ ]";
            if (dealersHand.size() != 0) {

                for (int i = 1; i < dealersHand.size(); i++) {
                    DHString = DHString + "[" + dealersHand.get(i) + "]";
                }
            }
        }
        return DHString;
    }

    // Prints the player's hand
    public static String printPH() {
        PHString = "";
        for (int i = 0; i < playersHand.size(); i++) {
            PHString = PHString + "[" + playersHand.get(i) + "]";
        }
        return PHString;
    }

    public static newCard card = new newCard();

    public static void hit() {
        newCard card = new newCard();
        c = card.printCard();
        playersHand.add(c);
        pTotal();
        if (ps < 21) {

            System.out.println("You did not bust.");
            dealerTurn();
        } else if (ps == 21) {
            playerWins();

        } else {

            System.out.println("You bust and lose.");
            printDH();
            printPH();
            System.out.printf("Your cards were %s, and the dealer had %s.%n", PHString, DHString);
            stillGoing = false;

        }
    }

    // OUTCOME METHODS
    public static void playerWins() {
        System.out.println("You win!");
        printDH();
        printPH();
        System.out.printf("Your cards were %s, and the dealer had %s.%n", PHString, DHString);
        stillGoing = false;

    }

    public static void playerLoses() {
        System.out.println("You lose.");
        printDH();
        printPH();
        System.out.printf("Your cards were %s, and the dealer had %s.%n", PHString, DHString);
        stillGoing = false;
    }

    // Dealer's turn method
    public static void dealerTurn() {

        handTotal(dealersHand);

        if (ds < 17) {
            newCard card = new newCard();

            c = card.printCard();
            dealersHand.add(c);
            System.out.printf("The dealer hits.%n");
            printDH();
            printPH();
            dealerStands = false;

        } else if (ds > 21) {
            gameCalc();
        } else if (ds > 16) {
            System.out.println("The dealer stands");
            printDH();
            System.out.printf("Your card(s) are %s, and the dealer is showing %s.%n", PHString, DHString);
            dealerStands = true;
            gameCalc();

        }
    }

    // Plays out the rest of the dealer's turn

    public static void dealerTurnAfterStand() {

        while (stillGoing == true) {
            dTotal();
            if (ds < 17) {
                newCard card = new newCard();

                c = card.printCard();

                dealersHand.add(c);
                printDH();
                printPH();
                dTotal();
                System.out.printf("The dealer hits. Your card(s) are %s, and the dealer is showing %s.%n", PHString,
                        DHString);

            } else if (ds > 21) {
                gameCalc();
            } else if (ds > 16) {
                System.out.println("The dealer stands");
                printDH();
                printPH();
                dTotal();
                System.out.printf("Your card(s) are %s, and the dealer is showing %s.%n", PHString, DHString);
                dealerStands = true;
                gameCalc();

            }
        }
    }

    // Method for player standing
    public static void stand() {
        if (stillGoing == true) {
            handTotal(dealersHand);
            while (handScore < 17) {
                dealerTurnAfterStand();
                handTotal(dealersHand);

            }
            stillGoing = false;
        }
    }

    public static void dTotal() {
        handTotal(dealersHand);
        ds = handScore;

    }

    public static void pTotal() {
        handTotal(playersHand);
        ps = handScore;
    }

    public static void gameCalc() {
        dTotal();
        pTotal();
        if (ds > ps || playerBust == true) {
            playerLoses();
            stillGoing = false;
        } else if (ds < ps) {
            playerWins();
            stillGoing = false;
        } else if (ps == ds) {
            System.out.printf("Both you and the dealer have a score of %d. You tie. %n", ds);
            stillGoing = false;
        } else if (ps > 21) {
            System.out.println("You bust.");
            stillGoing = false;
            playerLoses();
        } else if (ds > 21) {
            System.out.println("The dealer busts.");
            stillGoing = false;
            playerWins();
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        boolean running = true;

        // MAIN GAME LOOP

        while (running == true) {
            System.out.println("Enter Q to quit the game, or anything else to play a hand: ");
            handScore = 0;
            input = in.next();
            // checks to see if the user entered q
            comparee = "Q";
            if (compare() == true) {
                running = false;
                break;
            } else {
                setup();
            }

            // Asks user if they want to hit or stand

            while (stillGoing == true) {
                printDH();
                printPH();
                System.out.printf(
                        "Your card(s) are %s, and the dealer is showing %s. Enter 'H' to hit or 'S' to stand: ",
                        PHString, DHString);
                input = in.next();
                input.toLowerCase();
                if (input.contains("h")) {
                    hit();
                } else if (input.contains("s")) {
                    stand();
                    if (dealerStands == true) {
                        gameCalc();
                        break;
                    }

                }
            }
        }

    }
}