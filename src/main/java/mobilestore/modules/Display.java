package mobilestore.modules;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "battery")
@XmlType(propOrder = {"manufacture", "type", "inch", "price"})
public class Display {
    private String manufacture;
    private String type;
    private double inch;
    private int price;

    public int getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    @XmlElement
    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getType() {
        return type;
    }

    @XmlElement
    public void setType(String types) {
        this.type = type;
    }

    public double getInch() {
        return inch;
    }

    @XmlElement
    public void setInch(double inch) {
        this.inch = inch;
    }

    @Override
    public String toString() {
        return "{" +
                "manufacture='" + manufacture + '\'' +
                ", types='" + type + '\'' +
                ", inch=" + inch +
                ", price=" + price +
                '}';
    }
}
