package iphone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Display {
    private String manufacture;
    private String types;
    private double inch;

    public Display() {

    }

    public Display(String manufacture, String types) {
        this.manufacture = manufacture;
        this.types = types;

    }

    public Display(String manufacture, String types, double inch) {
        this.manufacture = manufacture;
        this.types = types;
        this.inch = inch;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public double getInch() {
        return inch;
    }

    public void setInch(double inch) {
        this.inch = inch;
    }

    @Override
    public String toString() {
        return ("\n" + "iphone.Display:" + "\n" + "Manufacture - " + getManufacture() + "\n" + "Types - " + getTypes() + "\n" + "Inch - " + getInch());
    }

}
