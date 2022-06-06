package mobilestore.pattern.abstractFactory;

import mobilestore.database.dao.interfaces.IBaseDAO;
import mobilestore.pattern.DAO;


public abstract class AbstractFactory {
    public abstract IBaseDAO getJdbcDAO(DAO dao);
    public abstract IBaseDAO getMyBatisDAO(DAO dao);

}
