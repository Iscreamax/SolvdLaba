package mobilestore.jdbc;

import mobilestore.database.dao.impl.mysql.BatteryDAO;
import mobilestore.database.dao.interfaces.IBatteryDAO;
import mobilestore.database.models.Battery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class JDBCRunner {
    private static final Logger LOGGER = LogManager.getLogger(JDBCRunner.class);

    public static void main(String[] args) {
        Battery battery = new Battery(3, "Apple", 1200, 35);
        IBatteryDAO b = new BatteryDAO();
        try {
            LOGGER.info(b.getEntityById(3));
            LOGGER.info(b.getEntityById(5));
            b.showAllBatteries();
            b.createEntity(new Battery(2,"Xiaomi", 3550, 33));
            b.createEntity(new Battery(1,"Xiaomi", 4150, 41));
            b.createEntity(new Battery(4,"Xiaomi", 4200, 47));
            b.removeEntity(13);
            b.updateEntity(battery);
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }
}
