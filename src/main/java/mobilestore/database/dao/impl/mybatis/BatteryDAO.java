package mobilestore.database.dao.impl.mybatis;


import mobilestore.database.dao.interfaces.IBatteryDAO;
import mobilestore.database.models.Battery;
import mobilestore.database.dao.mybatis.MyBatisUtil;
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
            LOGGER.info("Get battery " + batteryDAO.getEntityById(id));
            return batteryDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(Battery entity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IBatteryDAO batteryDAO = sqlSession.getMapper(IBatteryDAO.class);
            sqlSession.insert("createBattery", entity);
            LOGGER.info("The battery is created: " + entity);
            sqlSession.commit();
        }


    }

    @Override
    public void updateEntity(Battery entity) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IBatteryDAO userDAO = sqlSession.getMapper(IBatteryDAO.class);
            sqlSession.update("updateBattery", entity);
            LOGGER.info("The battery is updated: " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IBatteryDAO userDAO = sqlSession.getMapper(IBatteryDAO.class);
            LOGGER.info("The battery is deleted :" + userDAO.getEntityById(id));
            sqlSession.delete("removeBattery", id);
            sqlSession.commit();
        } catch (SQLException throwables) {
            LOGGER.info(throwables);
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
