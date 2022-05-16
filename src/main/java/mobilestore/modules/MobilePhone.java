package mobilestore.modules;

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
    public void setYear(int year) {
        this.year = year;
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

    public MobileStore getMobileStores() {
        return mobileStores;
    }

    public void setMobileStores(MobileStore mobileStores) {
        this.mobileStores = mobileStores;
    }

    public long getImei() {
        return imei;
    }

    public void setImei(long imei) {
        this.imei = imei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specification getSpecifications() {
        return specifications;
    }

    public void setSpecifications(Specification specifications) {
        this.specifications = specifications;
    }

    @Override
    public String toString() {
        return "\n"+"MobilePhone{" +
                "Name='" + name + '\'' +
                ", Year=" + year +
                ", Price=" + price +
                ", Imei=" + imei +
                ", MobileStores=" + mobileStores +
                ", Specifications=" + specifications +
                '}'+ "\n" ;
    }

}
