package mobilestore.dao;

import mobilestore.classes.MobileStore;

public interface IMobileStoreDAO extends IBaseDAO<MobileStore> {
    void getAllBatteries();
}
