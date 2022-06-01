package mobilestore.database.dao.impl.mybatis;

import mobilestore.database.dao.interfaces.IUserDAO;
import mobilestore.database.models.User;
import mobilestore.database.dao.mybatis.MyBatisUtil;
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
            LOGGER.info("Get user by id :" + userDAO.getEntityById(id));
            return userDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(User entity) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            sqlSession.insert("createEntity", entity);
            LOGGER.info("The user is created : " + entity);
            sqlSession.commit();
        }


    }

    @Override
    public void updateEntity(User entity) throws SQLException {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            sqlSession.update("updateEntity", entity);
            LOGGER.info("The user is updated : " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            try {
                LOGGER.info("The user is deleted :" + userDAO.getEntityById(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    @Override
    public List<User> getUsers() {
        List<User> users;

        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            IUserDAO userDAO = sqlSession.getMapper(IUserDAO.class);
            users= sqlSession.selectList("showAllUsers");

        }
        return users;
    }
}
