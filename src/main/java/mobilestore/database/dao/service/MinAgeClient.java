package mobilestore.database.dao.service;


import mobilestore.database.dao.impl.jdbc.ClientDAO;
import mobilestore.database.dao.interfaces.IClientDAO;
import mobilestore.database.dao.interfaces.IUserDAO;
import mobilestore.database.models.Client;
import mobilestore.database.models.User;
import mobilestore.pattern.DAO;
import mobilestore.pattern.abstractFactory.RunnerFactory;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class MinAgeClient {
    private static final Logger LOGGER = LogManager.getLogger(MinAgeClient.class);

    public static void deleteClientByAge(int age) {
        if (0 <= age && age <= 100) {
            IUserDAO iUserDAO =(IUserDAO) RunnerFactory.getFactory(DAO.JDBC).getJdbcDAO(DAO.USER);
            IClientDAO iClientDAO = (IClientDAO) RunnerFactory.getFactory(DAO.MY_BATIS).getMyBatisDAO(DAO.CLIENT);
            List<Client> clients = iClientDAO.getClients();
            List<User> users = iUserDAO.getUsers();
            for (int i = 0; i < clients.size(); i++) {
                for (User user : users) {
                    iterating(i,user,clients,age,iClientDAO);
                }
            }
            iClientDAO.showAllClients();
        } else throw new IllegalArgumentException("The age entered incorrectly");
    }

    public static void iterating(int i, User user, List<Client> clients, int age, IClientDAO iClientDAO) {
        if (user.getId() == clients.get(i).getUserId()) {
            if (user.getAge() < age) {
                iClientDAO.removeEntity(clients.get(i).getId());
                LOGGER.info("Client is removed : " + clients.get(i));
            }
        }
    }

    public static void main(String[] args) {
        IClientDAO iClientDAO = (IClientDAO) RunnerFactory.getFactory(DAO.MY_BATIS).getMyBatisDAO(DAO.CLIENT);
        iClientDAO.showAllClients();
        deleteClientByAge(19);
    }
}
