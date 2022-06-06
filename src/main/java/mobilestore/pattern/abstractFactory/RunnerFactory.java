package mobilestore.pattern.abstractFactory;


import mobilestore.pattern.factory.JDBCFactory;
import mobilestore.pattern.factory.MyBatisFactory;
import mobilestore.pattern.DAO;


public class RunnerFactory {

    public static AbstractFactory getFactory(DAO factory) {
        switch (factory) {
            case JDBC:
                return  new JDBCFactory();
            case MY_BATIS:
                return new MyBatisFactory();
            default:
                return null;

        }
    }
}
