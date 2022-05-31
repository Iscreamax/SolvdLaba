package mobilestore.database.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "battery")
@XmlType(propOrder = {"id","manufacturer", "capacity","price"})
@JsonPropertyOrder({"manufacturer", "capacity","price"})
public class Battery {
    @JsonProperty
    private int id;
    @JsonProperty
    private String manufacturer;
    @JsonProperty
    private int capacity;
    @JsonProperty
    private int price;

    public Battery(){}
    public Battery(String manufacturer, int capacity, int price) {
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.price = price;
    }

    public Battery(int id, String manufacturer, int capacity, int price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }
    @XmlElement
    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }
    @XmlElement
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }


    @XmlElement
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "{"+"id="+id +
                ", manufacturer='" + manufacturer + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

}
