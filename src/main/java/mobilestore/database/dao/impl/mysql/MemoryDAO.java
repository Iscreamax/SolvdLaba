package mobilestore.database.dao.impl.mysql;


import mobilestore.database.connectionpool.AbstractClassJDBC;
import mobilestore.database.dao.interfaces.IMemoryDAO;
import mobilestore.database.models.Memory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class MemoryDAO extends AbstractClassJDBC implements IMemoryDAO {
    private static final Logger LOGGER = LogManager.getLogger(MemoryDAO.class);
    private Memory m = new Memory();
    private Connection connection = null;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;

    @Override
    public void showAllMemories() {

        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from memories ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                m.setId(resultSet.getInt("id"));
                m.setName(resultSet.getString("manufacturer"));
                m.setCapacity(resultSet.getInt("capacity"));
                LOGGER.info(m);
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
    public Memory getEntityById(int id) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from memories where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                m.setId(resultSet.getInt("id"));
                m.setName(resultSet.getString("manufacturer"));
                m.setCapacity(resultSet.getInt("capacity"));
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
        return m;

    }

    @Override
    public void createEntity(Memory entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("insert into memories (manufacturer,capacity) values (?,?)");
            pr.setString(1, entity.getName());
            pr.setInt(2, entity.getCapacity());
            pr.executeUpdate();
            LOGGER.info("A new memory has been created: " + entity);
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
    public void updateEntity(Memory entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("update memories set manufacturer=?,capacity=? where id=?");
            pr.setString(1, entity.getName());
            pr.setInt(2, entity.getCapacity());
            pr.setInt(3, entity.getId());
            pr.executeUpdate();
            LOGGER.info("Memory data has been updated.");
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
            pr = connection.prepareStatement("delete from memories where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The memory has been removed.");
        } catch (SQLException e) {
            LOGGER.info(e);
        } finally {
            try {
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }
}
