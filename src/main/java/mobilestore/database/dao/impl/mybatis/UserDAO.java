package mobilestore.database.dao.impl.mybatis;

import mobilestore.database.dao.interfaces.IUserDAO;
import mobilestore.database.models.User;
import mobilestore.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);


    @Override
    public User getEntityById(int id) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            return userDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(User entity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            sqlSession.insert("createEntity", entity);
            sqlSession.commit();
        }


    }

    @Override
    public void updateEntity(User entity) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            sqlSession.update("updateEntity", entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            sqlSession.delete("removeEntity", id);
            sqlSession.commit();
        }
    }

    @Override
    public void showAllUsers() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            List<User> list = sqlSession.selectList("showAllUsers");
            list.stream().forEach(LOGGER::info);

        }
    }
}
