package mobilestore.modules;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "processor")
@XmlType(propOrder = {"name", "frequency", "noc"})
public class Processor {
    private String name;
    private String frequency;
    private int noc;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getFrequency() {
        return frequency;
    }

    @XmlElement
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getNoc() {
        return noc;
    }

    @XmlElement
    public void setNoc(int noc) {
        this.noc = noc;
    }

    @Override
    public String toString() {
        return "{" +
                ", name='" + name + '\'' +
                ", frequency='" + frequency + '\'' +
                ", noc=" + noc +
                '}';
    }
}
