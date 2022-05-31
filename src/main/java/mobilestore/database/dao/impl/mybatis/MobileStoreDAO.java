package mobilestore.database.dao.impl.mybatis;

import mobilestore.database.dao.interfaces.IMobileStoreDAO;

import mobilestore.database.models.MobileStore;
import mobilestore.database.dao.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class MobileStoreDAO implements IMobileStoreDAO {
    private static final Logger LOGGER = LogManager.getLogger(MobileStoreDAO.class);


    @Override
    public MobileStore getEntityById(int id) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMobileStoreDAO iMobileStoreDAO = sqlSession.getMapper(IMobileStoreDAO.class);
            LOGGER.info("Get MobileStore : "+iMobileStoreDAO.getEntityById(id));
            return iMobileStoreDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(MobileStore entity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMobileStoreDAO iMobileStoreDAO = sqlSession.getMapper(IMobileStoreDAO.class);
            sqlSession.insert("createMobileStore", entity);
            LOGGER.info("The MobileStore is created: "+entity);
            sqlSession.commit();
        }


    }

    @Override
    public void updateEntity(MobileStore entity) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMobileStoreDAO iMobileStoreDAO = sqlSession.getMapper(IMobileStoreDAO.class);
            sqlSession.update("updateMobileStore", entity);
            LOGGER.info("The MobileStore is updated: "+entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMobileStoreDAO iMobileStoreDAO = sqlSession.getMapper(IMobileStoreDAO.class);
            LOGGER.info("The MobileStore is deleted: " + iMobileStoreDAO.getEntityById(id));
            sqlSession.delete("removeMobileStore", id);
            sqlSession.commit();
        } catch (SQLException throwables) {
            LOGGER.info(throwables);
        }
    }

    @Override
    public void showAllMobileStores() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMobileStoreDAO iMobileStoreDAO = sqlSession.getMapper(IMobileStoreDAO.class);
            List<MobileStore> list = sqlSession.selectList("showAllMobileStores");
            list.stream().forEach(LOGGER::info);

        }
    }
}
