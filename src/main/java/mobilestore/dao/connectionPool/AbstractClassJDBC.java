package mobilestore.dao.connectionPool;

public class AbstractClassJDBC {
    private ConnectionPool connectionPool = ConnectionPool.newInstance();

    protected ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }
}
