package mobilestore.dao.jdbcMySQLImpl;

import iphone.Main;
import mobilestore.classes.Batteries;
import mobilestore.dao.IBatteryDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BatteryDAO implements IBatteryDAO {
    private static final Logger LOGGER = LogManager.getLogger(BatteryDAO.class);
    private long id;
    private String name;
    private int capacity;

    public BatteryDAO(long id, String name) {
        this.id = id;
        this.name = name;
    }

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
    public List<Batteries> getAllBatteries() throws SQLException {
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            List<Batteries> list = new ArrayList<Batteries>();
            try (PreparedStatement pr = con.prepareStatement("select *from users")) {
                try (ResultSet rs = pr.executeQuery()) {
                    while (rs.next()) {
                        Batteries b = new Batteries();
                        b.setId(rs.getLong("id"));
                        b.setName(rs.getString("manufacturer"));
                        b.setCapacity(rs.getInt("capacity"));
                        b.setPrice(rs.getInt("price"));
                        list.add(b);
                    }
                    return list;
                }
            }
        }
    }

    @Override
    public Batteries getEntityById(Long id) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String sqlCommand ="select *from users where id=?";
            try (PreparedStatement pr = con.prepareStatement(sqlCommand)) {
                pr.setLong(1, id);
                try (ResultSet rs = pr.executeQuery()) {
                    Batteries b = new Batteries();
                    b.setId(rs.getLong("id"));
                    b.setName(rs.getString("manufacturer"));
                    b.setCapacity(rs.getInt("capacity"));
                    b.setPrice(rs.getInt("price"));
                    return b;
                }
            }
        }
    }

    @Override
    public void saveEntity(Batteries entity) {

    }

    @Override
    public void updateEntity(Batteries entity) throws SQLException {

    }

    @Override
    public void removeEntity(long id) {

    }
}
