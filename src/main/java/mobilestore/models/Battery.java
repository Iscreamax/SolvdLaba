package mobilestore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "battery")
@XmlType(propOrder = {"name", "capacity","price"})
@JsonPropertyOrder({"name", "capacity","price"})
public class Battery {
    @JsonProperty
    private String name;
    @JsonProperty
    private int capacity;
    @JsonProperty
    private int price;

    public Battery(){}
    public Battery(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    @XmlElement
    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
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
        return "{" +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

}
