package Payroll;
// Theodore Truebe
// HW 29 Part B


public class Employee {
    private String name;
    protected double salary;

    /*
     * Constructor.
     */
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        salary = newSalary;
    }

    public double getAnnualIncome() {
        // Employees only get an annual salary.
        return getSalary();
    }

    
    public void displayInfo() {
        getAnnualIncome();
        System.out.println(name + ":");
        System.out.printf("  Salary = $%,.2f%n", salary);
    }
    
}