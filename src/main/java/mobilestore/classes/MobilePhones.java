package mobilestore.classes;

import java.util.List;

public class MobilePhones {
    private long id;
    private long mobileStoresId;
    private long imei;
    private String name;
    private List<Specifications> specifications;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMobileStoresId() {
        return mobileStoresId;
    }

    public void setMobileStoresId(long mobileStoresId) {
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

    public List<Specifications> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specifications> specifications) {
        this.specifications = specifications;
    }
}
