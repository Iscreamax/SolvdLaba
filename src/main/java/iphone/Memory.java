package iphone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Memory {
    private String manufacture;
    private int capacity;
    private static final Logger LOGGER = LogManager.getLogger(Memory.class);

    public Memory() {
    }

    public Memory(int capacity) {
        this.capacity = capacity;
    }

    public Memory(String manufacture, int capacity) {
        this.manufacture = manufacture;
        this.capacity = capacity;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return ("\n" + "iphone.Memory: " + "\n" + "Manufacture - " + getManufacture() + "\n" + "Capacity - " + getCapacity() + " Gb");

    }

}
