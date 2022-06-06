package mobilestore.database.dao.impl.jdbc;
import mobilestore.database.connectionpool.ConnectionPool;

import mobilestore.database.dao.interfaces.IWorkerDAO;
import mobilestore.database.models.Worker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO implements IWorkerDAO {
    private static final Logger LOGGER = LogManager.getLogger(WorkerDAO.class);
    private Worker worker = new Worker();
    private Connection connection = null;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;


    @Override
    public void showAllWorkers() {

        try {
            connection = ConnectionPool.getInstance().takeConnection();
            pr = connection.prepareStatement("select * from workers ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                worker.setId(resultSet.getInt("id"));
                worker.setPosition(resultSet.getString("position"));
                worker.setExperience(resultSet.getString("surname"));
                worker.setUserId(resultSet.getInt("user_id"));
                worker.setMobileStoreId(resultSet.getInt("mobile_store_id"));
                LOGGER.info(worker);
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
    public Worker  getEntityById(int id) {
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            pr = connection.prepareStatement("select * from workers where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                worker.setId(resultSet.getInt("id"));
                worker.setPosition(resultSet.getString("position"));
                worker.setExperience(resultSet.getString("surname"));
                worker.setUserId(resultSet.getInt("user_id"));
                worker.setMobileStoreId(resultSet.getInt("mobile_store_id"));
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
        return worker;

    }

    @Override
    public void createEntity(Worker entity) {
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            pr = connection.prepareStatement("insert into workers (position,experience,mobile_store_id,user_id) values (?,?,?,?)");
            pr.setString(1, entity.getPosition());
            pr.setString(2, entity.getExperience());
            pr.setInt(3, entity.getMobileStoreId());
            pr.setInt(4, entity.getUserId());
            pr.executeUpdate();
            LOGGER.info("A new worker has been created: " + entity);
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
    public void updateEntity(Worker entity) {
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            pr = connection.prepareStatement("update worker set position=?,experience=?,mobile_store_id=?,user_id=? where id=?");
            pr.setString(1, entity.getPosition());
            pr.setString(2, entity.getExperience());
            pr.setInt(3, entity.getMobileStoreId());
            pr.setInt(4, entity.getUserId());
            pr.setInt(5, entity.getId());
            pr.executeUpdate();
            LOGGER.info("Worker data has been updated.");
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
            pr = connection.prepareStatement("delete from workers where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The worker has been removed.");
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
    public List<Worker> getWorkers() {
        List<Worker> workers = new ArrayList<>();
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            pr = connection.prepareStatement("select * from users ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                Worker worker = new Worker();
                worker.setId(resultSet.getInt("id"));
                worker.setPosition(resultSet.getString("position"));
                worker.setExperience(resultSet.getString("surname"));
                worker.setUserId(resultSet.getInt("user_id"));
                worker.setMobileStoreId(resultSet.getInt("mobile_store_id"));
                workers.add(worker);
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
        return workers;
    }
}

