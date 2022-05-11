package mobilestore.dao.jdbcMySQLImpl;

import mobilestore.classes.MobileStore;
import mobilestore.dao.IMobileStoreDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MobileStoreDAO implements IMobileStoreDAO {
    private static final Logger LOGGER = LogManager.getLogger(MobileStoreDAO.class);
    private MobileStore mb = new MobileStore();
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
            pr = connection.prepareStatement("select * from mobile_stores ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                mb.setId(resultSet.getInt("id"));
                mb.setName(resultSet.getString("name"));
                mb.setAddress(resultSet.getString("address"));
                LOGGER.info(mb);
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
    public MobileStore getEntityById(int id) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("select * from mobile_stores where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                mb.setId(resultSet.getInt("id"));
                mb.setName(resultSet.getString("name"));
                mb.setAddress(resultSet.getString("address"));
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
        return mb;

    }

    @Override
    public void createEntity(MobileStore entity) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("insert into mobile_stores (name,address) values (?,?)");
            pr.setString(1, entity.getName());
            pr.setString(2, entity.getAddress());
            pr.executeUpdate();
            LOGGER.info("A new mobile store has been created: " + entity);
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
    public void updateEntity(MobileStore entity) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("update mobile_stores set name=?,address=?where id=?");
            pr.setString(1, entity.getName());
            pr.setString(2, entity.getAddress());
            pr.executeUpdate();
            LOGGER.info("Mobile store data has been updated.");
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
            pr = connection.prepareStatement("delete from mobile_store where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The mobile store has been removed.");
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
