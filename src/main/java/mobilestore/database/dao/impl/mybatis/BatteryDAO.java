package mobilestore.database.dao.impl.mybatis;


import mobilestore.database.dao.interfaces.IBatteryDAO;
import mobilestore.database.models.Battery;
import mobilestore.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class BatteryDAO implements IBatteryDAO {
    private static final Logger LOGGER = LogManager.getLogger(BatteryDAO.class);


    @Override
    public Battery getEntityById(int id) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IBatteryDAO batteryDAO = sqlSession.getMapper(IBatteryDAO.class);
            return batteryDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(Battery entity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IBatteryDAO batteryDAO = sqlSession.getMapper(IBatteryDAO.class);
            sqlSession.insert("createBattery", entity);
            sqlSession.commit();
        }


    }

    @Override
    public void updateEntity(Battery entity) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IBatteryDAO userDAO = sqlSession.getMapper(IBatteryDAO.class);
            sqlSession.update("updateBattery", entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IBatteryDAO userDAO = sqlSession.getMapper(IBatteryDAO.class);
            sqlSession.delete("removeBattery", id);
            sqlSession.commit();
        }
    }

    @Override
    public void showAllBatteries() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IBatteryDAO userDAO = sqlSession.getMapper(IBatteryDAO.class);
            List<Battery> list = sqlSession.selectList("showAllBatteries");
            list.stream().forEach(LOGGER::info);

        }
    }
}
