package mobilestore.dao;

import mobilestore.classes.Batteries;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IBatteryDAO extends IBaseDAO<Batteries> {
    List<Batteries> getAllBatteries () throws SQLException;
}
