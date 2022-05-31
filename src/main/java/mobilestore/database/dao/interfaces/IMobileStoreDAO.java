package mobilestore.database.dao.interfaces;


import mobilestore.database.models.MobileStore;

public interface IMobileStoreDAO extends IBaseDAO<MobileStore> {
    void getAllMobileStores();
}
