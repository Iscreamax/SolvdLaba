package mobilestore.classes;

public class Battery {
    private int id;
    private String name;
    private int capacity;
    private int price;

    public Battery() {
    }
    public Battery(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }
    public Battery(int id, String name, int capacity, int price) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

}
