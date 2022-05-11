package mobilestore.dao.jdbcMySQLImpl;

import mobilestore.classes.Client;
import mobilestore.dao.IClientDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ClientDAO implements IClientDAO {

    private static final Logger LOGGER = LogManager.getLogger(ClientDAO.class);
    private Client c = new Client();
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
            pr = connection.prepareStatement("select * from clients ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                c.setId(resultSet.getInt("id"));
                c.setCreditCardNumber(resultSet.getString("creditCardNumber"));
                c.setUserId(resultSet.getInt("userId"));
                c.setValidTHRU(resultSet.getString("validTHRU"));
                LOGGER.info(c);
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
    public Client getEntityById(int id) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("select * from clients where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                c.setId(resultSet.getInt("id"));
                c.setCreditCardNumber(resultSet.getString("creditCardNumber"));
                c.setUserId(resultSet.getInt("userId"));
                c.setValidTHRU(resultSet.getString("validTHRU"));
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
        return c;

    }

    @Override
    public void createEntity(Client entity) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("insert into clients (creditCardNumber,userId,validTHRU) values (?,?,?)");
            pr.setString(1, entity.getCreditCardNumber());
            pr.setInt(2, entity.getUserId());
            pr.setString(3, entity.getValidTHRU());
            pr.executeUpdate();
            LOGGER.info("A new client has been created: " + entity);
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
    public void updateEntity(Client entity) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            pr = connection.prepareStatement("update clients set creditCardNumber=?,userId=?,validTHRU=? where id=?");
            pr.setString(1, entity.getCreditCardNumber());
            pr.setInt(2, entity.getUserId());
            pr.setString(3, entity.getValidTHRU());
            pr.setInt(4, entity.getId());
            pr.executeUpdate();
            LOGGER.info("Client data has been updated.");
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
            pr = connection.prepareStatement("delete from clients where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The clients has been removed.");
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


