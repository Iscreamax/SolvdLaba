package mobilestore.modules;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlRootElement(name = "specification")
@XmlType(propOrder = {"id", "processor", "display", "battery", "memory"})
public class Specification {

    private int id;
    private Processor processor;
    private Display display;
    private Battery battery;
    private Memory memory;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public Processor getProcessor() {
        return processor;
    }

    @XmlElement
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Display getDisplay() {
        return display;
    }

    @XmlElement
    public void setDisplay(Display display) {
        this.display = display;
    }

    public Battery getBattery() {
        return battery;
    }

    @XmlElement

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Memory getMemory() {
        return memory;
    }

    @XmlElement

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
