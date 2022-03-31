package iphone;

import exception.BuyAgeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public final class MobileStore {
    private static final Logger LOGGER = LogManager.getLogger(MobileStore.class);
    public static final String WORKING_TIME = "Yes";


    static {
        System.out.print("Does the Mobile Store open?(Yes/No) ");
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.next().equals(WORKING_TIME)) {
                LOGGER.info("You are welcome!");

            } else {
                LOGGER.info("The Mobile Store is closed.Come back later!");
                Runtime.getRuntime().exit(0);
            }
        }
    }

    public static void buying(List purchased, Map warehouse, MobilePhone mobilePhone, Client client) {
        try {
            if (client.getAge() >= 18) {
//                 LOGGER.info(client.getFirstName() + " " + client.getSurname() + ", you've purchased the phone - " + mobilePhone.toString());
//                 LOGGER.info("The IMEI of this phone is - " + mobilePhone.imei);
                purchased.add(mobilePhone);
                warehouse.remove(mobilePhone.imei);
            } else throw new BuyAgeException("You're too younger to buy!");
        } catch (BuyAgeException e) {
            LOGGER.debug(e);
        }
    }

    public static void buying(MobilePhone mobilePhone, Client client) {
        try {
            if (client.getAge() >= 18) {
                LOGGER.info(client.getFirstName() + " " + client.getSurname() + ", you've purchased the phone - " + mobilePhone.toString());
                LOGGER.info("The IMEI of this phone is - " + mobilePhone.imei);
            } else throw new BuyAgeException("You're too younger to buy!");
        } catch (BuyAgeException e) {
            LOGGER.debug(e);
        }
    }
}

