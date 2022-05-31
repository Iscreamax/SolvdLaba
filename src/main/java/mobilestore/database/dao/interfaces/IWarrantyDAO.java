package mobilestore.database.dao.interfaces;

import mobilestore.database.models.Warranty;

public interface IWarrantyDAO extends IBaseDAO<Warranty>{
    void showAllWarranties();
}
