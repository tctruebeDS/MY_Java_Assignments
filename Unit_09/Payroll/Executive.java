package Payroll;
// Theodore Truebe
// HW 30 Part A
public class Executive extends Manager{
    private double stock;
    public Executive(String name, double salary, double bonus, double stock) {
        super(name, salary, bonus);
        // initialize the child class' members.
        this.stock = stock;
    }
    public double getStock(){
        return stock;
    }
    public void setStock(double stock) {
        this.stock = stock;
    }
    
    // overridden getAnnualIncome for the executive that includes the stock
    public double getAnnualIncome() {
        super.getAnnualIncome();
        getStock();
        return stock;
    }
    // Displays the info with the stock
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("  Stock  = $%,12.2f%n", stock);
    }
    public static void main(String[] args) {
        
    }
}
