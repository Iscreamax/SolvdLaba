package mobilestore.pattern.factory;


import mobilestore.database.dao.impl.jdbc.*;
import mobilestore.database.dao.interfaces.IBaseDAO;
import mobilestore.pattern.DAO;
import mobilestore.pattern.abstractFactory.AbstractFactory;


public class JDBCFactory extends AbstractFactory {
    public static IBaseDAO createDAO(DAO type){
        switch (type){
            case USER:
                return new UserDAO();
            case CLIENT:
                return new ClientDAO();
            case MEMORY:
                return new MemoryDAO();
            case BATTERY:
                return new BatteryDAO();
            case MOBILE_STORE:
                return new MobileStoreDAO();
            default:
                return null;
        }
    }

    @Override
    public IBaseDAO getJdbcDAO(DAO dao) {
        return (IBaseDAO) createDAO(dao);
    }

    @Override
    public IBaseDAO getMyBatisDAO(DAO dao) {
        return null;
    }
}
