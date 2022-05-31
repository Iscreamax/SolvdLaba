package mobilestore.database.dao.impl.mybatis;

import mobilestore.database.dao.interfaces.IMemoryDAO;
import mobilestore.database.models.Memory;
import mobilestore.mybatis.MyBatisUtil;
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
            return memoryDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(Memory entity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMemoryDAO memoryDAO = sqlSession.getMapper(IMemoryDAO.class);
            sqlSession.insert("createMemory", entity);
            sqlSession.commit();
        }


    }

    @Override
    public void updateEntity(Memory entity) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMemoryDAO memoryDAO = sqlSession.getMapper(IMemoryDAO.class);
            sqlSession.update("updateMemory", entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IMemoryDAO memoryDAO = sqlSession.getMapper(IMemoryDAO.class);
            sqlSession.delete("removeMemory", id);
            sqlSession.commit();
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
