package mobilestore.database.dao.interfaces;


import mobilestore.database.models.MobilePhone;

public interface IMobilePhoneDAO extends IBaseDAO<MobilePhone>{
    void showAllMobilePhones ();
}
