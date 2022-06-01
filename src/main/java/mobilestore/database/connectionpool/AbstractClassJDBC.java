package mobilestore.database.connectionpool;

public class AbstractClassJDBC {
    private ConnectionPool connectionPool = ConnectionPool.newInstance();

    protected ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }
}
