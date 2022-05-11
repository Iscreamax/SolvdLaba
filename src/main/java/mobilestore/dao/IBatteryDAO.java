package mobilestore.dao;

import mobilestore.classes.Battery;

import java.sql.SQLException;

public interface IBatteryDAO extends IBaseDAO<Battery> {
    void getAllBatteries ();
}
