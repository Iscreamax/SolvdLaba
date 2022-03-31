package iphone;

import exception.DiscountException;
import exception.PriceException;
import exception.WarehouseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    Memory memory = new Memory("Profit", 256);
    Battery batteryIphone = new Battery("Apple", 3300);
    Display displayIphone = new Display("Samsung", "Oled", 6.1);
    Display displayIphoneMax = new Display("Samsung", "Oled", 6.5);
    Cpu cpuIphone = new Cpu("Bionic", 2.7);
    Battery batterySamsungS = new Battery("Samsung", 4300);
    Battery batterySamsungAE = new Battery("Samsung", 3300);
    Display displaySamsung = new Display("Samsung", "Oled", 6.4);
    Cpu cpuSamsung = new Cpu("Exynos", 2.9);
    Client firstClient = new Client("Jack ", "Vorobey ", "Aleksandrovich", 18);
    Client secondClient = new Client("Valet ", "Kozirny ", "Albertovich", 25);
    Client thirdClient = new Client("Vitya", "Samuel", "Viktorovich", 13);
    Client fourthClient = new Client("Lex", "Jan", "Hu", 20);
    Client fifthClient = new Client("Vitya", "Samuel", "Viktorovich", 55);
    Message message = new Message("I'm going to be late for work, I'm sorry!");
    Message emptyMessage = new Message("");
    MobilePhone iphonePro = new Iphone(13, "Pro", memory, batteryIphone, displayIphone, cpuIphone, 1350, true);
    MobilePhone iphoneMini = new Iphone(12, "Mini", memory, batteryIphone, displayIphone, cpuIphone, 1200, false);
    MobilePhone iphoneProMax = new Iphone(13, "Pro Max", memory, batteryIphone, displayIphoneMax, cpuIphone, 1500, true);
    MobilePhone samsungS = new Samsung(21, "S", memory, batterySamsungS, displaySamsung, cpuSamsung, 1270);
    MobilePhone samsungA = new Samsung(51, "A", memory, batterySamsungAE, displaySamsung, cpuSamsung, 310);
    MobilePhone samsungE = new Samsung(34, "E", memory, batterySamsungAE, displaySamsung, cpuSamsung, 270);
    Landline philips = new Landline("Philips", 2230, "One", 60);
    Landline lg = new Landline("LG", 007, "Home", 110);
    MobileStore mobileStore = new MobileStore();

    public void previousLesson() {
        LOGGER.info("Previous Lesson" + "\n");
        LOGGER.info(iphonePro.toString());
        LOGGER.info(memory.toString());
        LOGGER.info(batteryIphone.toString());
        LOGGER.info(displayIphone.toString());
        LOGGER.info(cpuIphone.toString());
        LOGGER.info("");
        LOGGER.info("Sending a message:");
        iphonePro.sendMessage(message, firstClient, secondClient);
        System.out.println("Making a call:");
        iphonePro.makeCall(firstClient, secondClient);
        System.out.println("We change names and make a call:");
        firstClient.setFirstName("Max ");
        secondClient.setFirstName("Oleg ");
        iphonePro.makeCall(firstClient, secondClient);
    }

    public void thirdLesson() {

        //buy new iphone.Iphone
        //turn on iphone.Iphone
        //establish an iPhone connection with a satellite
        //registering a user
        //setting up an Iphone Internet connection
        //registering an account
        //installing the app in the App store
        //updating the iphone.Iphone
        //taking photos on iphone.Iphone
        //shooting a video on an iphone.Iphone
        //a call to the 911 service from an iphone.Iphone

//        appleStore.buying(iphonePro, firstClient);
        iphonePro.turnOnMobile();
        iphonePro.satelliteConnection();
        iphonePro.internetConnection();
        iphonePro.registration(firstClient);
        iphonePro.update();
        iphonePro.installingApplication();
        iphonePro.makePhoto();
        iphonePro.makeVideo();
        iphonePro.alarmCall();
        LOGGER.info("");

        //buy new iphone.Samsung
        //turn on iphone.Samsung
        //establish a Samsung connection with a satellite
        //registering a user
        //setting up a iphone.Samsung Internet connection
        //registering an account
        //installing the app in the Play Market
        //updating the iphone.Samsung
        //taking photos on iphone.Samsung
        //shooting a video on a iphone.Samsung
        //a call to the 911 service from a iphone.Samsung


//        newSamsung.buying(samsungS, secondClient);
        samsungS.turnOnMobile();
        samsungS.satelliteConnection();
        samsungS.internetConnection();
        samsungS.registration(secondClient);
        samsungS.installingApplication();
        samsungS.update();
        samsungS.makePhoto();
        samsungS.makeVideo();
        samsungS.alarmCall();
        MobilePhone.created();
    }

    public void fourthLesson() {
        LOGGER.info("Equals iphone.Landline: " + philips.equals(lg));
        LOGGER.info("Equals iphone.Iphone: " + iphonePro.equals(iphoneMini));
        LOGGER.info("Equals iphone.Samsung: " + samsungS.equals(iphoneMini));
        LOGGER.info("iphone.Samsung hashCode: " + samsungS.hashCode());
        LOGGER.info("iphone.Iphone hashCode: " + iphonePro.hashCode());
        LOGGER.info("IphoneMini hashCode: " + iphoneMini.hashCode());
        LOGGER.info("Philips hashCode: " + philips.hashCode());
        LOGGER.info("LG hashCode: " + lg.hashCode());
    }

    public void fifthLesson() throws Exception {


        //attempt to send an empty message
        iphonePro.sendMessage(emptyMessage, firstClient, secondClient);
        //attempt to purchase a phone by a minor
//        iStore.buying(iphoneMini, thirdClient);
        //attempt to enter incorrect data
        //attempt to set price = 0;
        SaleShop discount = new SaleShop();


        try {
            discount.getDiscount(iphonePro, "g");
        } catch (PriceException e) {
            LOGGER.debug(e);
        }
    }


    public void collectionLesson() {
        LOGGER.info("\n" + "Collection of battery:");
        Set<Battery> battery = new LinkedHashSet<>();
        battery.add(batteryIphone);
        battery.add(batterySamsungAE);
        battery.add(batterySamsungS);

        for (Object o : battery) {
            System.out.println(o);
        }

        LOGGER.info("\n" + "Collection of people:");
        Set<Client> clients = new LinkedHashSet<>();
        clients.add(firstClient);
        clients.add(secondClient);
        clients.add(thirdClient);
        clients.add(fourthClient);
        clients.add(fifthClient);
        for (Object o : clients) {
            LOGGER.info(o);
        }
        LOGGER.info("\n" + "Collection of mobile phones in warehouse:");

        // created a depot with new mobile phones
        Map<String, MobilePhone> warehouse = new HashMap();
        warehouse.put(iphonePro.imei, iphonePro);
        warehouse.put(iphoneMini.imei, iphoneMini);
        warehouse.put(iphoneProMax.imei, iphoneProMax);
        warehouse.put(samsungS.imei, samsungS);
        warehouse.put(samsungA.imei, samsungA);
        warehouse.put(samsungE.imei, samsungE);
        Set warehouseSet = warehouse.entrySet();
        for (Map.Entry<String, MobilePhone> o : warehouse.entrySet()) {
            LOGGER.info(o.getKey() + o.getValue());
        }

        LOGGER.info("\n" + "Collection of purchased mobile phones that are being removed from the warehouse:");
        ArrayList<MobilePhone> purchasedPhones = new ArrayList<>();
        MobileStore.buying(purchasedPhones, warehouse, iphoneMini, firstClient);
        MobileStore.buying(purchasedPhones, warehouse, samsungE, secondClient);
        MobileStore.buying(purchasedPhones, warehouse, iphonePro, fourthClient);
        for (Object o : purchasedPhones) {
            LOGGER.info(o);
        }

        LOGGER.info("\n" + "Remaining phones in warehouse:");
        for (Map.Entry<String, MobilePhone> o : warehouse.entrySet()) {
            LOGGER.info(o.getKey() + o.getValue());
        }

        LOGGER.info("\n" + "Collection of transmitted mobile phones that are being removed from the warehouse::");
        Set<SaleShop> saleShop = new TreeSet<>();
        try {
            saleShop.add(new SaleShop(40, samsungA, warehouse));
            saleShop.add(new SaleShop(30, samsungS, warehouse));
            saleShop.add(new SaleShop(20, iphoneProMax, warehouse));
        } catch (WarehouseException e) {
            LOGGER.info(e);
        } catch (DiscountException ex) {
            LOGGER.info(ex);
        } catch (PriceException exi) {
            LOGGER.info(exi);
        }
        for (Object o : saleShop) {
            LOGGER.info(o);
        }

        LOGGER.info("\n" + "Remaining phones in warehouse");
        LOGGER.info(warehouse.size());
    }


    public static void main(String[] args) {
        Main main = new Main();
//        main.previousLesson();
//        main.thirdLesson();
//       main.fourthLesson();
//        main.fifthLesson();
        main.collectionLesson();


    }
}
