package mobilestore.dao.jdbcMySQLImpl;


import mobilestore.classes.User;
import mobilestore.dao.IUserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class UserDAO implements IUserDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);
    private User u = new User();
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
    public User getEntityById(int id) {
        try {
            connection = DriverManager.getConnection(url, username, password);
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
            try {
                if (connection != null) connection.close();
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
            connection = DriverManager.getConnection(url, username, password);
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
            try {
                if (connection != null) connection.close();
                if (pr != null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e);
            }
        }
    }

    @Override
    public void updateEntity(User entity) {
        try {
            connection = DriverManager.getConnection(url, username, password);
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
            pr = connection.prepareStatement("delete from users where id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The user has been removed.");
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
