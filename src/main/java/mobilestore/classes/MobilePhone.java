package mobilestore.classes;

import java.util.List;

public class MobilePhone {
    private int id;
    private int mobileStoresId;
    private long imei;
    private String name;
    private List<Specification> specifications;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMobileStoresId() {
        return mobileStoresId;
    }

    public void setMobileStoresId(int mobileStoresId) {
        this.mobileStoresId = mobileStoresId;
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

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }
}
