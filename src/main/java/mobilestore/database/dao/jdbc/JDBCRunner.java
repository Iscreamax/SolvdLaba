package mobilestore.database.dao.jdbc;


import mobilestore.database.dao.interfaces.IBatteryDAO;
import mobilestore.database.models.Battery;
import mobilestore.pattern.DAO;
import mobilestore.pattern.factory.JDBCFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class JDBCRunner {
    private static final Logger LOGGER = LogManager.getLogger(JDBCRunner.class);

    public static void main(String[] args) {
        Battery battery = new Battery.Builder().setId(3).setManufacturer("Apple").setCapacity(1200).setPrice(35).build();
        IBatteryDAO b = (IBatteryDAO) JDBCFactory.createDAO(DAO.BATTERY);
        try {
            LOGGER.info(b.getEntityById(3));
            LOGGER.info(b.getEntityById(5));
            b.showAllBatteries();
            b.createEntity(new Battery.Builder().setManufacturer("Xiaomi").setCapacity(3550).setPrice(33).build());
            b.createEntity(new Battery.Builder().setManufacturer("Xiaomi").setCapacity(4150).setPrice(41).build());
            b.createEntity(new Battery.Builder().setManufacturer("Xiaomi").setCapacity(4200).setPrice(47).build());
            b.removeEntity(13);
            b.updateEntity(battery);
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }
}
