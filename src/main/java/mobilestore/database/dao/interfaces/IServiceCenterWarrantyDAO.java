package mobilestore.database.dao.interfaces;

import mobilestore.database.models.ServiceCentersWarranty;

public interface IServiceCenterWarrantyDAO extends IBaseDAO<ServiceCentersWarranty> {
    void showAllServiceCentersWarranties();
}
