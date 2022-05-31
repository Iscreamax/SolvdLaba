package mobilestore.database.dao.impl.mybatis;


import mobilestore.database.dao.interfaces.IClientDAO;
import mobilestore.database.models.Client;
import mobilestore.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class ClientDAO implements IClientDAO {
    private static final Logger LOGGER = LogManager.getLogger(ClientDAO.class);


    @Override
    public Client getEntityById(int id) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IClientDAO iClientDAO = sqlSession.getMapper(IClientDAO.class);
            return iClientDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(Client entity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IClientDAO iClientDAO = sqlSession.getMapper(IClientDAO.class);
            sqlSession.insert("createClients", entity);
            sqlSession.commit();
        }


    }

    @Override
    public void updateEntity(Client entity) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IClientDAO iClientDAO = sqlSession.getMapper(IClientDAO.class);
            sqlSession.update("updateClients", entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IClientDAO iClientDAO = sqlSession.getMapper(IClientDAO.class);
            sqlSession.delete("removeClients", id);
            sqlSession.commit();
        }
    }

    @Override
    public void showAllClients() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IClientDAO iClientDAO = sqlSession.getMapper(IClientDAO.class);
            List<Client> list = sqlSession.selectList("showAllClients");
            list.stream().forEach(LOGGER::info);

        }
    }
}
