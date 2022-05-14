package mobilestore.dao.interfaces;

import mobilestore.classes.Battery;

public interface IBatteryDAO extends IBaseDAO<Battery> {
    void getAllBatteries ();
}
