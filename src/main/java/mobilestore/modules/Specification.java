package mobilestore.modules;

public class Specification {

    private int id;
    private Processor processor;
    private Display display;
    private Battery battery;
    private Memory memory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return "{" +
                "processor=" + processor +
                ", display=" + display +
                ", battery=" + battery +
                ", memory=" + memory +
                '}';
    }


}
