package mobilestore.database.dao.interfaces;

import mobilestore.database.models.User;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface IBaseDAO <T>{
    T getEntityById( int id) throws SQLException;
    void createEntity(T entity);
    void updateEntity(T entity) throws SQLException;
    void removeEntity(int id);
}
