import java.util.ArrayList;
import java.util.Scanner;
// Theodore Truebe
// R03 Hw
/*
 * 1-3
 * 1-2
 * 3-2
 * 1-3
 * 2-1
 * 2-3
 * 1-3
 */
public class R03 {

    ArrayList<Integer> tower1 = new ArrayList<>();
    ArrayList<Integer> tower2 = new ArrayList<>();
    ArrayList<Integer> tower3 = new ArrayList<>();

    public void hanoi(int n, int start, int end) {
        // if (n == 3) {
        // printMove(start, end);
        // printMove(start, getInterim(start, end));
        // printMove(end, getInterim(start, end));
        // printMove(start, end);
        // printMove(getInterim(start, end), start);
        // printMove(getInterim(start, end), end);
        // printMove(start, end);
        // }else

        // {
        // int interim = getInterim(start, end);
        // hanoi(n - 1, start, interim);
        // printMove(start, end);
        // hanoi(n - 1, interim, end);
        // }
        if (n == 1) {
            printMove(start, end);
        } else {
            int interim = getInterim(start, end);
            hanoi(n - 1, start, interim);
            printMove(start, end);
            hanoi(n - 1, interim, end);
        }

    }

    public static int getInterim(int start, int end) {
        return 6 - start - end;
    }

    public void printMove(int start, int end) {
        move(start, end);
        printTowers();
    }

    public void move(int start, int end) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> fromTower = getTower(start);
        ArrayList<Integer> toTower = getTower(end);
        if (!fromTower.isEmpty()) {
            toTower.add(fromTower.remove(fromTower.size() - 1));
        }
    }

    public ArrayList<Integer> getTower(int towerNumber) {
        switch (towerNumber) {
            case 1:
                return tower1;
            case 2:
                return tower2;
            case 3:
                return tower3;
            default:
                throw new IllegalArgumentException("huh?");
        }
    }

    public void printTowers() {
        int maxHeight = Math.max(tower1.size(), Math.max(tower2.size(), tower3.size()));
        for (int i = maxHeight - 1; i >= 0; i--) {
            System.out.println(
                    getDiscs(tower1, i) + "   " +
                            getDiscs(tower2, i) + "   " +
                            getDiscs(tower3, i));
        }
        System.out.println("T1       T2       T3");
    }

    public String getDiscs(ArrayList<Integer> tower, int level) {
        if (level < tower.size()) {
            int discSize = tower.get(level);
            return "*".repeat(discSize) + " ".repeat(6 - discSize); 
        } else {
            return " ".repeat(6);
        }
    }

    public void Towers(int n) {

        for (int i = n; i >= 1; i--) {
            tower1.add(i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        R03 hanoi = new R03();
        System.out.println();
        System.out.print("Enter the number of discs or (q)uit: ");
        if (in.hasNext("q") || in.hasNext("Q")) {
        } else if (in.hasNextInt()) {
            int numDiscs = in.nextInt();
            hanoi.Towers(numDiscs);
            hanoi.printTowers();
            hanoi.hanoi(numDiscs, 1, 3);
        } else {
            System.err.println("Error.");
        }

        in.close();
    }
}