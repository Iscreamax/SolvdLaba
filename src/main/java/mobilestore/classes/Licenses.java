package mobilestore.classes;

import java.util.List;

public class Licenses {
    private List<ServiceCenters> serviceCenters;
    private List<MobileStores> mobileStores;

    public List<ServiceCenters> getServiceCenters() {
        return serviceCenters;
    }

    public void setServiceCenters(List<ServiceCenters> serviceCenters) {
        this.serviceCenters = serviceCenters;
    }

    public List<MobileStores> getMobileStores() {
        return mobileStores;
    }

    public void setMobileStores(List<MobileStores> mobileStores) {
        this.mobileStores = mobileStores;
    }


}
