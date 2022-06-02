package mobilestore.database.dao.impl.jdbc;


import mobilestore.database.connectionpool.AbstractClassJDBC;
import mobilestore.database.dao.interfaces.IClientDAO;
import mobilestore.database.models.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.*;

public class ClientDAO extends AbstractClassJDBC implements IClientDAO {

    private static final Logger LOGGER = LogManager.getLogger(ClientDAO.class);
    private Client c = new Client();
    private Connection connection = null;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    @Override
    public void showAllClients() {

        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from clients ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                c.setId(resultSet.getInt("id"));
                c.setCreditCardNumber(resultSet.getString("creditCardNumber"));
                c.setUserId(resultSet.getInt("user_id"));
                c.setValidTHRU(resultSet.getString("validTHRU"));
                LOGGER.info(c);
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            getConnectionPool().returnConnection(connection);
            try {
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
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from clients where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                c.setId(resultSet.getInt("id"));
                c.setCreditCardNumber(resultSet.getString("creditCardNumber"));
                c.setUserId(resultSet.getInt("user_id"));
                c.setValidTHRU(resultSet.getString("validTHRU"));
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            getConnectionPool().returnConnection(connection);
            try {
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
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("insert into clients (creditCardNumber,userId,validTHRU) values (?,?,?)");
            pr.setString(1, entity.getCreditCardNumber());
            pr.setInt(2, entity.getUserId());
            pr.setString(3, entity.getValidTHRU());
            pr.executeUpdate();
            LOGGER.info("A new client has been created: " + entity);
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void updateEntity(Client entity) {
        try {
            connection = getConnectionPool().takeConnection();
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
            getConnectionPool().returnConnection(connection);
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
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("delete from clients where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The clients has been removed.");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public List<Client> getClients() {
        List<Client> clients = new ArrayList<>();
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from clients ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                Client client= new Client();
                client.setId(resultSet.getInt("id"));
                client.setCreditCardNumber(resultSet.getString("creditCardNumber"));
                client.setUserId(resultSet.getInt("user_id"));
                client.setValidTHRU(resultSet.getString("validTHRU"));
                clients.add(client);
            }
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            getConnectionPool().returnConnection(connection);
            try {
                if (pr != null) pr.close();
                if (resultSet != null) resultSet.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
        return clients;
    }

}


