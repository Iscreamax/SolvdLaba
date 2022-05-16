package mobilestore.modules;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAttribute;

@XmlRootElement(name = "mobile_phone")
@XmlType(propOrder = {"id", "name", "imei", "year", "price", "mobileStores", "specifications"})
public class MobilePhone {
    private int id;
    private MobileStore mobileStores;
    private long imei;
    private String name;
    private int year;
    private int price;
    private Specification specifications;

    public int getYear() {
        return year;
    }

    @XmlElement
    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    @XmlElement
    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public MobileStore getMobileStores() {
        return mobileStores;
    }

    @XmlElement
    public void setMobileStores(MobileStore mobileStores) {
        this.mobileStores = mobileStores;
    }

    public long getImei() {
        return imei;
    }

    @XmlElement
    public void setImei(long imei) {
        this.imei = imei;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Specification getSpecifications() {
        return specifications;
    }

    @XmlElement
    public void setSpecifications(Specification specifications) {
        this.specifications = specifications;
    }

    @Override
    public String toString() {
        return "\n" + "MobilePhone{" +
                "Name='" + name + '\'' +
                ", Year=" + year +
                ", Price=" + price +
                ", Imei=" + imei +
                ", MobileStores=" + mobileStores +
                ", Specifications=" + specifications +
                '}' + "\n";
    }

}
