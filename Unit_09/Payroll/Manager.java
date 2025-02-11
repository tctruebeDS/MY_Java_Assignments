package Payroll;
// Theodore Truebe
// HW 29 Part B
public class Manager extends Employee {
    // Private member variable
    private double bonus;
    // Manager constructor includes bonus field
    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        // initialize the child class' members.
        this.bonus = bonus;
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
        salary = salary + bonus;
        return salary;
    }
    public void displayInfo() {
        super.displayInfo();
        
        System.out.printf("  Bonus  = $%,12.2f%n", bonus);
   }
   
   public String toString() {
       return super.toString() + "[bonus = " + bonus + "]";
   }
   
   public boolean equals(Object obj) {
       final double SMALL_NUMBER = 0.0000000000001;
       if (obj instanceof Manager == false) {
           return false;
       }
       Manager otherMgr = (Manager) obj;
       if (super.equals(otherMgr) == false) {
           return false;
       }
       if (Math.abs(this.bonus - otherMgr.bonus) < SMALL_NUMBER) {
           return true;
       } else {
           return false;
       }
   }


    public static void main(String[] args) {
        Manager andy = new Manager("Andy", 100000, 25000);
        System.out.println(andy);
        Manager steve = new Manager("Steve Young", 75000, 15);
        Manager mryoung = new Manager("Steve Young", 75000, 15);

        if (steve.equals(mryoung)) {
            System.out.println("There are duplicate entries.");
        } else {
            System.out.println("There are NO duplicate entries.");
        }

        // Employee e = new Employee("Larry", 15);
        // Manager m = new Manager("Jim", 15, 15);
        // m.setBonus(30);
        // // Formatted prints the payroll for both people
        // e.displayInfo();
        // m.displayInfo();
    }
}
