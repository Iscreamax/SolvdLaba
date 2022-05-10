package mobilestore.classes;

import java.util.List;

public class ServiceCentersWarranties {
    public List<ServiceCenters> getServiceCenters() {
        return serviceCenters;
    }

    public void setServiceCenters(List<ServiceCenters> serviceCenters) {
        this.serviceCenters = serviceCenters;
    }

    public List<Warranties> getWarranties() {
        return warranties;
    }

    public void setWarranties(List<Warranties> warranties) {
        this.warranties = warranties;
    }

    private List<ServiceCenters> serviceCenters;
   private List<Warranties> warranties;
}
