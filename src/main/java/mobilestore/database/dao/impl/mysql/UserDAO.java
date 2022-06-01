package mobilestore.database.dao.impl.mysql;
import mobilestore.database.connectionpool.AbstractClassJDBC;
import mobilestore.database.dao.interfaces.IUserDAO;
import mobilestore.database.models.Client;
import mobilestore.database.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractClassJDBC implements IUserDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private User u = new User();
    private Connection connection = null;
    private PreparedStatement pr = null;
    private ResultSet resultSet = null;


    @Override
    public void showAllUsers() {

        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from users ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setSurname(resultSet.getString("surname"));
                u.setEmail(resultSet.getString("email"));
                u.setAge(resultSet.getInt("age"));
                LOGGER.info(u);
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
    public User  getEntityById(int id) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from users where id=?");
            pr.setInt(1, id);
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setSurname(resultSet.getString("surname"));
                u.setEmail(resultSet.getString("email"));
                u.setAge(resultSet.getInt("age"));
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
        return u;

    }

    @Override
    public void createEntity(User entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("insert into users (name,surname,email,age) values (?,?,?,?)");
            pr.setString(1, entity.getName());
            pr.setString(2, entity.getSurname());
            pr.setString(3, entity.getEmail());
            pr.setInt(4, entity.getAge());
            pr.executeUpdate();
            LOGGER.info("A new user has been created: " + entity);
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
    public void updateEntity(User entity) {
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("update users set name=?,surname=?,email=?,age=? where id=?");
            pr.setString(1, entity.getName());
            pr.setString(2, entity.getSurname());
            pr.setString(3, entity.getEmail());
            pr.setInt(4, entity.getAge());
            pr.setInt(5, entity.getId());
            pr.executeUpdate();
            LOGGER.info("User data has been updated.");
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
            pr = connection.prepareStatement("delete from users where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The user has been removed.");
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
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            connection = getConnectionPool().takeConnection();
            pr = connection.prepareStatement("select * from users ");
            pr.execute();
            resultSet = pr.getResultSet();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setEmail(resultSet.getString("email"));
                user.setAge(resultSet.getInt("age"));
                users.add(user);
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
        return users;
    }
}
