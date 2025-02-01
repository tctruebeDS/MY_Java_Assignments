public class Customer {
    private String companyName;
    private double totalSales;
    private int numberSales;
    private int regionCode;
    private int serialNumber;
    public static int lastSerialUsed = 0;

    public Customer(String name, int regionCode) {
        companyName = name;
        totalSales = 0;
        numberSales = 0;
        this.regionCode = regionCode;

        lastSerialUsed++;
        serialNumber = lastSerialUsed;
    }

    public String getName() {
        // Implement here.
        return companyName;

    }

    public void setName(String new_name) {
        // Implement here.
    }

    public void setRegion(int new_region) {
        // Implement here.
    }

    public int getRegion() {
        // Implement here.
        return regionCode;
    }

    public void addSale(double amount) {
        // Implement here.
        totalSales += amount;
    }

    public double getSales() {
        // Implement here.
        return totalSales;
    }

    public int getNumber() {
        // Implement here.
        return serialNumber;
    }

    public double getAverage() {
        // Implement here.
        return totalSales / numberSales;
    }
    
    public Customer(String name) {
        // put overloaded implementation here
        regionCode = 1;
    }

    public static void main(String[] args) {
       Customer.lastSerialUsed = 100;
       Customer c1 = new Customer("Sal's Deli");
       c1.addSale(100);
       Customer c2 = c1;
       c2.addSale(50);
       System.out.println(c1.getSales());
       System.out.println(c2.getSales());

    }
}
