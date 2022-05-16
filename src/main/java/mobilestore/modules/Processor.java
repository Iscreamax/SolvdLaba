package mobilestore.modules;

public class Processor {
    private String name;
    private String frequency;
    private int noc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getNoc() {
        return noc;
    }

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
