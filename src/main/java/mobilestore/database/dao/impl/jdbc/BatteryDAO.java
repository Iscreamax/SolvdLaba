package mobilestore.database.dao.impl.jdbc;



import mobilestore.database.connectionpool.ConnectionPool;
import mobilestore.database.dao.interfaces.IBatteryDAO;
import mobilestore.database.models.Battery;
import mobilestore.pattern.builder.BatteryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;

public class BatteryDAO  implements IBatteryDAO {
    private static final Logger LOGGER = LogManager.getLogger(BatteryDAO.class);
    private BatteryBuilder builder = new BatteryBuilder();
    private Battery b = new Battery(builder);
    private Connection connection = null;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;


    @Override
    public void showAllBatteries() {

        try {
            connection = ConnectionPool.getInstance().takeConnection();
            pr = connection.prepareStatement("select * from batteries ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                b.setId(resultSet.getInt("id"));
                b.setManufacturer(resultSet.getString("manufacturer"));
                b.setCapacity(resultSet.getInt("capacity"));
                b.setPrice(resultSet.getInt("price"));
                LOGGER.info(b);
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
            try {
                if (pr != null) pr.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public Battery getEntityById(int id) {
        try {
            connection = ConnectionPool.newInstance().takeConnection();
            pr = connection.prepareStatement("select * from batteries where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                b.setId(resultSet.getInt("id"));
                b.setManufacturer(resultSet.getString("manufacturer"));
                b.setCapacity(resultSet.getInt("capacity"));
                b.setPrice(resultSet.getInt("price"));
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
            try {
                if (pr != null) pr.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
        return b;

    }

    @Override
    public void createEntity(Battery entity) {
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            pr = connection.prepareStatement("insert into batteries (manufacturer,capacity,price) values (?,?,?)");
            pr.setString(1, entity.getManufacturer());
            pr.setInt(2, entity.getCapacity());
            pr.setInt(3, entity.getPrice());
            pr.executeUpdate();
            LOGGER.info("A new battery has been created: " + entity);
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
            try {
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void updateEntity(Battery entity) {
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            pr = connection.prepareStatement("update batteries set manufacturer=?,capacity=?,price=? where id=?");
            pr.setString(1, entity.getManufacturer());
            pr.setInt(2, entity.getCapacity());
            pr.setInt(3, entity.getPrice());
            pr.setInt(4, entity.getId());
            pr.executeUpdate();
            LOGGER.info("Battery data has been updated.");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
            try {
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void removeEntity(int id) {
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            pr = connection.prepareStatement("delete from batteries where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The battery has been removed.");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            ConnectionPool.getInstance().returnConnection(connection);
            try {
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }
}
