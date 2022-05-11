package mobilestore.classes;

import java.util.List;

public class License {
    private List<ServiceCenter> serviceCenters;
    private List<MobileStore> mobileStores;

    public List<ServiceCenter> getServiceCenters() {
        return serviceCenters;
    }

    public void setServiceCenters(List<ServiceCenter> serviceCenters) {
        this.serviceCenters = serviceCenters;
    }

    public List<MobileStore> getMobileStores() {
        return mobileStores;
    }

    public void setMobileStores(List<MobileStore> mobileStores) {
        this.mobileStores = mobileStores;
    }
}
