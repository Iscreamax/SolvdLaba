package iphone;

import java.util.Objects;

public class Landline extends Phone {
    private String brand;

    public Landline(String brand, int model, String version, int price) {
        super(model, version, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Landline that = (Landline) obj;
        if (getBrand() != ((Landline) obj).brand) return false;
        if (getModel() != ((Landline) obj).getModel()) return false;

        return Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        int result = getModel() == 0 ? 0 : Objects.hashCode(getModel());
        result = 31 * result * getPrice();
        result = 31 * result * getBrand().hashCode();
        result = 31 * result * getVersion().hashCode();
        return result;
    }

}
