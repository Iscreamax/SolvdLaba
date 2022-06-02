package mobilestore.database.dao.service;


import mobilestore.database.dao.impl.jdbc.ClientDAO;
import mobilestore.database.dao.impl.jdbc.UserDAO;
import mobilestore.database.dao.interfaces.IClientDAO;
import mobilestore.database.dao.interfaces.IUserDAO;
import mobilestore.database.models.Client;
import mobilestore.database.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class MinAgeClient {
    private static final Logger LOGGER = LogManager.getLogger(MinAgeClient.class);

    public static void deleteClientByAge(int age){
        if(0<=age&&age<=100){
            IUserDAO iUserDAO = new UserDAO();
            IClientDAO iClientDAO= new ClientDAO();
            List<Client> clients=iClientDAO.getClients();
            List<User> users = iUserDAO.getUsers();
            for (int i = 0; i < clients.size(); i++) {
                for(User u: users){
                    if(u.getId()==clients.get(i).getUserId()){
                        if(u.getAge()<age){
                            iClientDAO.removeEntity(clients.get(i).getId());
                            LOGGER.info("Client is removed : "+clients.get(i) );
                        }
                    }
                }
            }
            iClientDAO.showAllClients();

        }
    }

    public static void main(String[] args) {
        IClientDAO iClientDAO = new ClientDAO();
        iClientDAO.showAllClients();
        deleteClientByAge(27);
    }
}
