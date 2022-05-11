package mobilestore.classes;

import java.util.List;

public class ServiceCentersWarranty{
    private List<ServiceCenter> serviceCenters;
    private List<Warranty> warranties;

    public List<ServiceCenter> getServiceCenters() {
        return serviceCenters;
    }

    public void setServiceCenters(List<ServiceCenter> serviceCenters) {
        this.serviceCenters = serviceCenters;
    }

    public List<Warranty> getWarranties() {
        return warranties;
    }

    public void setWarranties(List<Warranty> warranties) {
        this.warranties = warranties;
    }

}
