package mobilestore.classes;

import java.util.List;

public class Specification {
    private int id;
    private List<Processor> processor;
    private List<Display> display;
    private List<Battery>battery;
    private List<Memory>memory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Processor> getProcessor() {
        return processor;
    }

    public void setProcessor(List<Processor> processor) {
        this.processor = processor;
    }

    public List<Display> getDisplay() {
        return display;
    }

    public void setDisplay(List<Display> display) {
        this.display = display;
    }

    public List<Battery> getBattery() {
        return battery;
    }

    public void setBattery(List<Battery> battery) {
        this.battery = battery;
    }

    public List<Memory> getMemory() {
        return memory;
    }

    public void setMemory(List<Memory> memory) {
        this.memory = memory;
    }

    public Specification(List<Processor> processor, List<Display> display, List<Battery> battery, List<Memory> memory) {
        this.processor = processor;
        this.display = display;
        this.battery = battery;
        this.memory = memory;
    }
}
