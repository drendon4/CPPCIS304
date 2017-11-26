
public class Car {

    private String VIN;
    private String make;
    private String model;
    private int year;

    public Car(String aVIN, String aMake, String aModel, int aYear) {
        VIN = aVIN;
        make = aMake;
        model = aModel;
        year = aYear;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        //returns string of car variables
        String result = "VIN Number: " + VIN + "\nCar Make: " + make + "\nCar Model: " + model + "\nCar Year: " + year + "\n";
        return result;
    }
}
