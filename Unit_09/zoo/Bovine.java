package zoo;

public class Bovine extends Mammal {
    private double hayConsumed;

    public Bovine(String name, double weight) {
        super(name, weight);
    }

    public void feedHay(double pounds) {
        hayConsumed = hayConsumed + pounds;
    }

    public double getHayConsumed() {
        return hayConsumed;
    }
    
    public void printName() {
        System.out.println(name);
    }
    
    public void printInfo() {
        System.out.println("Name: " + this.getName());
        System.out.println("Hay: " + hayConsumed);
    }


}