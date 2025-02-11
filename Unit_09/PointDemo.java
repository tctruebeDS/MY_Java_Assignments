public class PointDemo {
    public int x;
    public int y;
    public PointDemo() {
        x = 0;
        y = 0;
    }
    public PointDemo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) {
            // classes don't match
            return false;
        }
        // cast o into a PointDemo type
        PointDemo otherPoint = (PointDemo) o;

        // compare coordinates
        if (otherPoint.x == this.x && otherPoint.y == this.y) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PointDemo p1 = new PointDemo(1,2);
        PointDemo p2 = new PointDemo(1,2);

        if (p1.equals(p2)){
            System.out.println("They are the same");
        } else {
            System.out.println("not like us");
        }
    }
}
