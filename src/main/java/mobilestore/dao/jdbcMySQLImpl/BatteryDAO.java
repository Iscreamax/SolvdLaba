package mobilestore.dao.jdbcMySQLImpl;


import mobilestore.classes.Battery;
import mobilestore.dao.IBatteryDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class BatteryDAO implements IBatteryDAO {
    private static final Logger LOGGER = LogManager.getLogger(BatteryDAO.class);
    private Battery b = new Battery();
    private Connection connection = null;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    private static Properties p = new Properties();
    private String url = p.getProperty("db.url");
    private String username = p.getProperty("db.username");
    private String password = p.getProperty("db.password");

    static {

        try (FileInputStream in = new FileInputStream("src/main/resources/db.properties")) {
            p.load(in);
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    @Override
    public void getAllBatteries() {

        try {
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("select * from batteries ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                b.setId(resultSet.getInt("id"));
                b.setName(resultSet.getString("manufacturer"));
                b.setCapacity(resultSet.getInt("capacity"));
                b.setPrice(resultSet.getInt("price"));
                LOGGER.info(b);
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
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
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("select * from batteries where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                b.setId(resultSet.getInt("id"));
                b.setName(resultSet.getString("manufacturer"));
                b.setCapacity(resultSet.getInt("capacity"));
                b.setPrice(resultSet.getInt("price"));
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
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
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("insert into batteries (manufacturer,capacity,price) values (?,?,?)");
            pr.setString(1, entity.getName());
            pr.setInt(2, entity.getCapacity());
            pr.setInt(3, entity.getPrice());
            pr.executeUpdate();
            LOGGER.info("A new battery has been created: " + entity);
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void updateEntity(Battery entity) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("update batteries set manufacturer=?,capacity=?,price=? where id=?");
            pr.setString(1, entity.getName());
            pr.setInt(2, entity.getCapacity());
            pr.setInt(3, entity.getPrice());
            pr.setInt(4, entity.getId());
            pr.executeUpdate();
            LOGGER.info("Battery data has been updated.");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void removeEntity(int id) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("delete from batteries where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The battery has been removed.");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (connection != null) connection.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }
}
