package Payroll;
// Theodore Truebe
// HW 29 Part B
public class Manager extends Employee {
    // Private member variable
    private double bonus;
    // Manager constructor includes bonus field
    public Manager(String name, double salary, double bonus) {
        super(name, salary);

    }
    
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // overridden getAnnualIncome for the manager that includes the bonus
    public double getAnnualIncome() {
        super.getAnnualIncome();
        getBonus();
        salary += bonus;
        return salary;
    }

    public static void main(String[] args) {
        Employee e = new Employee("Larry", 15);
        Manager m = new Manager("Jim", 15, 15);
        m.setBonus(30);
        // Formatted prints the payroll for both people
        e.printPayroll();
        m.printPayroll();
    }
}
