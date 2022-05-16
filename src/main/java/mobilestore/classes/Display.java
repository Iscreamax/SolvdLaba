package mobilestore.classes;

public class Display {
    private int id;
    private String manufacturer;
    private String type;
    private String inch;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String types) {
        this.type = types;
    }

    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Display{" +
                "manufacturer='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", inch=" + inch +
                ", price=" + price +
                '}';
    }

}
