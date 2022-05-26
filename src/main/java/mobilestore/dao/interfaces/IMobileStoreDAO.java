package mobilestore.dao.interfaces;

import mobilestore.classes.MobileStore;

public interface IMobileStoreDAO extends IBaseDAO<MobileStore> {
    void getAllMobileStores();
}
