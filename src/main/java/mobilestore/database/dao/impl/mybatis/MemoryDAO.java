package mobilestore.database.dao.impl.mybatis;

import mobilestore.database.dao.interfaces.IMemoryDAO;
import mobilestore.database.models.Memory;
import mobilestore.database.dao.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class MemoryDAO implements IMemoryDAO {
    private static final Logger LOGGER = LogManager.getLogger(MemoryDAO.class);


    @Override
    public Memory getEntityById(int id) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMemoryDAO memoryDAO = sqlSession.getMapper(IMemoryDAO.class);
            LOGGER.info("Get memory by id :"+memoryDAO.getEntityById(id));
            return memoryDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(Memory entity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMemoryDAO memoryDAO = sqlSession.getMapper(IMemoryDAO.class);
            sqlSession.insert("createMemory", entity);
            LOGGER.info("The memory is created :"+entity);
            sqlSession.commit();
        }


    }

    @Override
    public void updateEntity(Memory entity) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMemoryDAO memoryDAO = sqlSession.getMapper(IMemoryDAO.class);
            sqlSession.update("updateMemory", entity);
            LOGGER.info("The memory is updated :"+entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMemoryDAO memoryDAO = sqlSession.getMapper(IMemoryDAO.class);
            LOGGER.info("The memory is deleted : "+ memoryDAO.getEntityById(id));
            sqlSession.delete("removeMemory", id);
            sqlSession.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void showAllMemories() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMemoryDAO memoryDAO = sqlSession.getMapper(IMemoryDAO.class);
            List<Memory> list =sqlSession.selectList("showAllMemories");
            list.stream().forEach(LOGGER::info);

        }
    }
}
