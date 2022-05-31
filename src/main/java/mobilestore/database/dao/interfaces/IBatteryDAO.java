package mobilestore.database.dao.interfaces;


import mobilestore.database.models.Battery;

public interface IBatteryDAO extends IBaseDAO<Battery> {
    void showAllBatteries ();
}
