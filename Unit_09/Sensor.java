// Theodore Truebe
// HW30 Part B

public abstract class Sensor {
    private String name;
    private int modelNumber;
    
    public void setName(String name) {
        this.name = name;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getName() {
        return name;
    }

    public int getModelNumber() {
        return modelNumber;
    }
    public abstract void recordMeasurement();
    public static void main(String[] args) {

    }
}
