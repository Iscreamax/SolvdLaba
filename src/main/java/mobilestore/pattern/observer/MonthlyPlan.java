package mobilestore.pattern.observer;

import mobilestore.database.dao.interfaces.IUserDAO;
import mobilestore.database.models.Worker;
import mobilestore.pattern.DAO;
import mobilestore.pattern.factory.JDBCFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class MonthlyPlan {
    private static final Logger LOGGER = LogManager.getLogger(MonthlyPlan.class);

    public static void main(String[] args) {

        JavaDeveloperMobileStore mobileStore = new JavaDeveloperMobileStore();
        Worker firstWorker = new Worker("Administrator", "3 year", 1, 1);
        Worker secondWorker = new Worker("Seller", "2 year 2 months", 8, 1);
        Worker thirdWorker = new Worker("Seller", "1 year  3 months", 10, 1);
        IUserDAO u = (IUserDAO) JDBCFactory.createDAO(DAO.USER);

        try {
            Observer firstSubscriber = new Subscriber(u.getEntityById(1).getName(), firstWorker.getPosition());
            Observer secondSubscriber = new Subscriber(u.getEntityById(8).getName(), secondWorker.getPosition());
            Observer thirdSubscriber = new Subscriber(u.getEntityById(10).getName(), thirdWorker.getPosition());
            mobileStore.addObserver(firstSubscriber);
            mobileStore.addObserver(secondSubscriber);
            mobileStore.addObserver(thirdSubscriber);
        } catch (SQLException e) {
            LOGGER.info(e);
        }
        mobileStore.addMonthlyPlan("Sales plan for August : 985 mobile phones");
        mobileStore.addMonthlyPlan("Sales plan for June : 1350 mobile phones");
        mobileStore.addMonthlyPlan("Sales plan for July : 2035 mobile phones");
    }
}
