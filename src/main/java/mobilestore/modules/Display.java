package mobilestore.modules;

public class Display {
    private String manufacture;
    private String types;
    private double inch;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public double getInch() {
        return inch;
    }

    public void setInch(double inch) {
        this.inch = inch;
    }

    @Override
    public String toString() {
        return "{" +
                "manufacture='" + manufacture + '\'' +
                ", types='" + types + '\'' +
                ", inch=" + inch +
                ", price=" + price +
                '}';
    }
}
