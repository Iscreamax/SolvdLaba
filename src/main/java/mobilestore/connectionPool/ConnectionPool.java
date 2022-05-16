package mobilestore.connectionPool;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool connectionPool;
    private int conAmount = 0;
    private int maxAmount = 5;

    private static final List<Connection> connectionList = Collections.synchronizedList(new ArrayList<>());
    private ConnectionPool(){

    }

    public static synchronized ConnectionPool newInstance() {
        if (connectionPool == null) {
            LOGGER.info("POOL is created");
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }
    public synchronized Connection takeConnection() {
        if (!connectionList.isEmpty()) {
            return connectionList.remove(0);
        } else if (conAmount < maxAmount) {
            try {
                conAmount++;
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/mobilestore", "root", "root");
            } catch (SQLException throwables) {
                conAmount--;
                LOGGER.info(throwables);
            }
        }
        return null;
    }

    public synchronized void returnConnection(Connection connection) {
        if (connection != null) connectionList.add(connection);
        LOGGER.debug("Connection is returned to POOL");

    }

}

