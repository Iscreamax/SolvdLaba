package mobilestore.pattern.observer;

import mobilestore.database.dao.impl.mybatis.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Subscriber implements Observer {
    private static final Logger LOGGER = LogManager.getLogger(Subscriber.class);

    private String name;
    private String position;

    public Subscriber(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void notify(List<String> monthlyPlans) {
        LOGGER.info("Dear " + position + " " + name + "\n We send the store's sales plan for June, July, August : \n" + monthlyPlans +
                "\n===================================================================\n");

    }
}
