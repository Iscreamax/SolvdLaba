package mobilestore.modules;

public class Battery {
    private String name;
    private int capacity;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        return "{" +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

}
