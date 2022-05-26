package mobilestore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "mobile_store")
@XmlType(propOrder = {"name", "address"})
@JsonPropertyOrder({"name", "address"})
public class MobileStore {
    @JsonProperty
    private String name;
    @JsonProperty
    private String address;

    public MobileStore(){}
    public MobileStore(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
