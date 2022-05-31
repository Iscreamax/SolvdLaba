package mobilestore.database.dao.interfaces;

import mobilestore.database.models.ServiceCenter;

public interface IServiceCenterDAO extends IBaseDAO<ServiceCenter> {
    void showAllServiceCenters ();
}
