package mobilestore.database.dao.mybatis;

import mobilestore.database.dao.impl.mybatis.BatteryDAO;
import mobilestore.database.dao.impl.mybatis.MemoryDAO;
import mobilestore.database.dao.impl.mybatis.ClientDAO;
import mobilestore.database.dao.impl.mybatis.MobileStoreDAO;
import mobilestore.database.dao.interfaces.IBatteryDAO;
import mobilestore.database.dao.interfaces.IClientDAO;
import mobilestore.database.dao.interfaces.IMemoryDAO;
import mobilestore.database.dao.interfaces.IMobileStoreDAO;
import mobilestore.database.models.Battery;
import mobilestore.database.models.Client;
import mobilestore.database.models.Memory;

import mobilestore.database.models.MobileStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;


public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);

    public static void runBatteryDao() {

        IBatteryDAO iBatteryDAO = new BatteryDAO();
        Battery battery = new Battery("Samsung", 3400, 23);
        Battery batteryUpdate = new Battery(4, "Apple", 4500, 55);
        //get battery by id
        try {
            LOGGER.info(iBatteryDAO.getEntityById(3));
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        //create battery
        iBatteryDAO.createEntity(battery);
        //update battery
        try {
            iBatteryDAO.updateEntity(batteryUpdate);
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        //delete battery
        iBatteryDAO.removeEntity(5);
        //show all batteries
        iBatteryDAO.showAllBatteries();

    }

    public static void runMemoryDao() {
        IMemoryDAO iMemoryDAO = new MemoryDAO();
        Memory memory = new Memory("CD", 265);
        Memory memoryUpdate = new Memory(2, "JD", 128);
        //create memory
        iMemoryDAO.createEntity(memory);
        //get memory by id
        try {
            LOGGER.info(iMemoryDAO.getEntityById(1));
        } catch (SQLException e) {
            LOGGER.info(e);
        }
//        //update memory
//        try {
//            iMemoryDAO.updateEntity(memoryUpdate);
//        } catch (SQLException e) {
//            LOGGER.info(e);
//        }
//        //delete memory
//        iMemoryDAO.removeEntity(1);
//        //show all batteries
//        iMemoryDAO.showAllMemories();
    }

    public static void runClientDao() {
        IClientDAO iClientDAO = new ClientDAO();
        Client client = new Client("12332543681", 21, "20/24");
        Client clientUpdate = new Client(3, "8763254361", 22, "18/28");
        //create client
        iClientDAO.createEntity(client);
//        get client by id
        try {
            LOGGER.info(iClientDAO.getEntityById(2));
        } catch (SQLException e) {
            LOGGER.info(e);
        }
//        update client
        try {
            iClientDAO.updateEntity(clientUpdate);
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        //delete client
        iClientDAO.removeEntity(1);
        //show all clients
//        iClientDAO.showAllClients();
    }

    public static void MobileStoreDao() {
        IMobileStoreDAO iMobileStoreDAO = new MobileStoreDAO();
        MobileStore mobileStore = new MobileStore("Mobile Centre", "92 Masherov Avenue");
        MobileStore mobileStoreUpdate = new MobileStore(4, "Mobile World", "Nemiga Street 21");
        //create mobileStore
//        iMobileStoreDAO.createEntity(mobileStore);
////        get mobileStore by id
//        try {
//            LOGGER.info(iMobileStoreDAO.getEntityById(1));
//        } catch (SQLException e) {
//            LOGGER.info(e);
//        }
////        update mobileStore
//        try {
//            iMobileStoreDAO.updateEntity(mobileStoreUpdate);
//        } catch (SQLException e) {
//            LOGGER.info(e);
//        }
        //delete client
        iMobileStoreDAO.removeEntity(4);
        //show all clients
//        iMobileStoreDAO.showAllMobileStores();
    }

    public static void main(String[] args) {

//        MyBatisMain.runBatteryDao();
//        MyBatisMain.runMemoryDao();
//        MyBatisMain.runClientDao();
//        MyBatisMain.MobileStoreDao();
        IClientDAO clientDAO = new ClientDAO();
        clientDAO.showAllClients();
    }
}
