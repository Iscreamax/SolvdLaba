package iphone;

import enums.Features;
import exception.DiscountException;
import exception.PriceException;
import exception.WarehouseException;
import inerfaces.fuctional.*;
import linkedList.LinkedList;
import mobilestore.dao.interfaces.IBatteryDAO;
import mobilestore.dao.jdbcMySQLImpl.BatteryDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

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
    MobilePhone iphonePro = new Iphone(13, "Pro", memory, batteryIphone, displayIphone, cpuIphone, 1350);
    MobilePhone iphoneMini = new Iphone(12, "Mini", memory, batteryIphone, displayIphone, cpuIphone, 1200);
    MobilePhone iphoneProMax = new Iphone(13, "Pro Max", memory, batteryIphone, displayIphoneMax, cpuIphone, 1500);
    MobilePhone samsungS = new Samsung(21, "S", memory, batterySamsungS, displaySamsung, cpuSamsung, 1270);
    MobilePhone samsungA = new Samsung(51, "A", memory, batterySamsungAE, displaySamsung, cpuSamsung, 310);
    MobilePhone samsungE = new Samsung(34, "E", memory, batterySamsungAE, displaySamsung, cpuSamsung, 270);
    Landline philips = new Landline("Philips", 2230, "One", 60);
    Landline lg = new Landline("LG", 007, "Home", 110);
    mobilestore.classes.Battery batteryBD= new mobilestore.classes.Battery(3,"Apple",1200,35);

    private void runPreviousLesson() {
        LOGGER.info("Previous Lesson" + "\n");
        LOGGER.info(iphonePro);
        LOGGER.info(memory);
        LOGGER.info(batteryIphone);
        LOGGER.info(displayIphone);
        LOGGER.info(cpuIphone);
        LOGGER.info("");
        LOGGER.info("Sending a message:");
        iphonePro.sendMessage(message, firstClient, secondClient);
        LOGGER.info("Making a call:");
        iphonePro.makeCall(firstClient, secondClient);
        LOGGER.info("We change names and make a call:");
        firstClient.setFirstName("Max ");
        secondClient.setFirstName("Oleg ");
        iphonePro.makeCall(firstClient, secondClient);
    }

    private void runThirdLesson() {


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
        MobileStore appleStore = new MobileStore();
        appleStore.buying(iphonePro, firstClient);
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

        MobileStore samsungStore = new MobileStore();
        samsungStore.buying(samsungS, secondClient);
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

    private void runFourthLesson() {
        LOGGER.info("Equals iphone.Landline: " + philips.equals(lg));
        LOGGER.info("Equals iphone.Iphone: " + iphonePro.equals(iphoneMini));
        LOGGER.info("Equals iphone.Samsung: " + samsungS.equals(iphoneMini));
        LOGGER.info("iphone.Samsung hashCode: " + samsungS.hashCode());
        LOGGER.info("iphone.Iphone hashCode: " + iphonePro.hashCode());
        LOGGER.info("IphoneMini hashCode: " + iphoneMini.hashCode());
        LOGGER.info("Philips hashCode: " + philips.hashCode());
        LOGGER.info("LG hashCode: " + lg.hashCode());
    }

    private void runFifthLesson() {


        //attempt to send an empty message
        iphonePro.sendMessage(emptyMessage, firstClient, secondClient);
        //attempt to enter incorrect data
        //attempt to set price = 0;
        SaleShop discount = new SaleShop();
        try {
            discount.setPercent(10);
            discount.countDiscount(iphonePro, "g");
        } catch (PriceException e) {
            LOGGER.debug(e);
        } catch (DiscountException e) {
            e.printStackTrace();
        }
    }


    private void useCollectionLesson() {
        LOGGER.info("\n" + "Collection of battery:");
        Set<Battery> battery = new HashSet<>();
        battery.add(batteryIphone);
        battery.add(batterySamsungAE);
        battery.add(batterySamsungS);
        battery.stream().forEach(LOGGER::info);

        LOGGER.info("\n" + "Collection of people:");
        Set<Client> clients = new HashSet<>();
        clients.add(firstClient);
        clients.add(secondClient);
        clients.add(thirdClient);
        clients.add(fourthClient);
        clients.add(fifthClient);
        clients.stream().sorted().forEach(LOGGER::info);

        LOGGER.info("\n" + "Collection of mobile phones in warehouse:");
        // created a depot with new mobile phones
        Map<String, MobilePhone> warehouse = new HashMap<>();
        warehouse.put(iphonePro.getImei(), iphonePro);
        warehouse.put(iphoneMini.getImei(), iphoneMini);
        warehouse.put(iphoneProMax.getImei(), iphoneProMax);
        warehouse.put(samsungS.getImei(), samsungS);
        warehouse.put(samsungA.getImei(), samsungA);
        warehouse.put(samsungE.getImei(), samsungE);
        warehouse.entrySet().stream().map(o -> o.getKey() + " " + o.getValue()).forEach(LOGGER::info);


        LOGGER.info("\n" + "Collection of purchased mobile phones that are being removed from the warehouse:");

        ArrayList<MobilePhone> purchasedPhones = new ArrayList<>();
        MobileStore.buying(purchasedPhones, warehouse, iphoneMini, firstClient);
        MobileStore.buying(purchasedPhones, warehouse, samsungE, secondClient);
        MobileStore.buying(purchasedPhones, warehouse, iphonePro, fourthClient);
        purchasedPhones.stream().forEach(LOGGER::info);

        LOGGER.info("\n" + "Remaining phones in warehouse:");
        warehouse.entrySet().stream().map(o -> o.getKey() + " " + o.getValue()).forEach(LOGGER::info);


        LOGGER.info("\n" + "Collection of transmitted mobile phones that are being removed from the warehouse::");
        Set<SaleShop> saleShop = new TreeSet<>();
        try {
            saleShop.add(new SaleShop(40, samsungA, warehouse));
            saleShop.add(new SaleShop(30, samsungS, warehouse));
            saleShop.add(new SaleShop(20, iphoneProMax, warehouse));
        } catch (WarehouseException e) {
            LOGGER.info(e);
        }
        saleShop.stream().forEach(LOGGER::info);

        LOGGER.info("\n" + "Remaining phones in warehouse");
        LOGGER.info(warehouse.size());

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("B");
        linkedList.addLast("C");
        linkedList.addLast("D");
        linkedList.addLast("E");
        LOGGER.info("LL: " + linkedList);
        linkedList.addFirst("A");
        LOGGER.info("LL: " + linkedList);
        LOGGER.info("Index of element with value E: " + linkedList.get("E"));
        LOGGER.info("Index of element with value Z: " + linkedList.get("Z"));
        linkedList.remove("C");
        LOGGER.info("LL: " + linkedList);
    }

    private void useUtilsLesson() {

        try {
            String s = StringUtils.lowerCase(FileUtils.readFileToString(new File("src/main/resources/text.txt"))).replaceAll("[^\\da-zA-Z ]", "");
            String[] words = s.split(" ");
            Set<String> uniqWords = new HashSet<>(List.of(words));
            List<String> count = uniqWords.stream().map(o -> o + ": " + StringUtils.countMatches(s, o)).collect(Collectors.toList());
            FileUtils.writeLines(new File("src/main/resources/count.txt"), count);
            LOGGER.info("count.txt was created!");
        } catch (IOException e) {
            LOGGER.debug(e);
        }
    }

    private void useLambdaAndEnumLesson() {
        //lambda implementation

        Predicate<MobilePhone> isIphonePro = x -> x.equals(iphonePro);
        LOGGER.info(isIphonePro.test(samsungS));
        LOGGER.info(isIphonePro.test(iphonePro));
        LOGGER.info(isIphonePro.test(iphoneProMax));

        BinaryOperator<Double> converter = (x, y) -> x * y;
        LOGGER.info("The cost of this " + iphonePro + " : " + converter.apply((double) iphonePro.getPrice(), 2.9) + " BYR");
        LOGGER.info("The cost of this " + samsungS + " : " + converter.apply((double) samsungS.getPrice(), 2.9) + " BYR");
        LOGGER.info("The cost of this " + samsungA + " : " + converter.apply((double) samsungA.getPrice(), 2.9) + " BYR");

        Consumer<Client> creditworthiness = x -> LOGGER.info("The client " + x + " is not creditworthy.");
        creditworthiness.accept(firstClient);
        creditworthiness.accept(secondClient);

        ICalculateMiddleAge mid = (n1, n2, n3, n4, n5) -> (n1 + n2 + n3 + n4 + n5) / 5;
        LOGGER.info("The average age is : " + mid.calculate(firstClient.getAge(), secondClient.getAge(), thirdClient.getAge(), fourthClient.getAge(), firstClient.getAge()));

        ICompare c = (x, y) -> {
            if (x > y) {
                return "The first mobile is more expensive";
            } else {
                return "The second mobile is more expensive";
            }
        };
        LOGGER.info(c.compare(iphonePro.getPrice(), samsungE.getPrice()));
        LOGGER.info(c.compare(samsungE.getPrice(), samsungS.getPrice()));

        IConvertInch con = (d) -> {
            double x = d * 2.54;
            return String.valueOf(x);
        };
        LOGGER.info(iphonePro.getDisplay().getInch() + " inches is " + con.convertInch(iphonePro.getDisplay().getInch()) + " centimeters'.");
        LOGGER.info(iphoneProMax.getDisplay().getInch() + " inches is " + con.convertInch(iphoneProMax.getDisplay().getInch()) + " centimeters'.");
        LOGGER.info(samsungS.getDisplay().getInch() + " inches is " + con.convertInch(samsungS.getDisplay().getInch()) + " centimeters'.");

        ICountWorkingTime workingTime = (w) -> {
            double x = w / 200;
            return x;
        };
        LOGGER.info(iphonePro.toString() + ": keeps the battery for " + workingTime.count(iphonePro.getBattery().getCapacity()) + " hours of use");
        LOGGER.info(samsungS.toString() + ": keeps the battery for " + workingTime.count(samsungS.getBattery().getCapacity()) + " hours of use");


        //Enum implementation
        LOGGER.info(Features.IPHONE.getMainFeatures().getValue());
        LOGGER.info(Features.IPHONE.getSubFeatures().getValue());
        LOGGER.info(Features.IPS.getMainFeatures().getValue());
        LOGGER.info(Features.IPS.getSubFeatures().getValue());
        LOGGER.info(Features.MAH.getMainFeatures().getValue());
        LOGGER.info(Features.MAH.getSubFeatures().getValue());
        LOGGER.info(Features.GB.getMainFeatures().getValue());
        LOGGER.info(Features.GB.getSubFeatures().getValue());


    }

    private void useReflection() {
        Constructor[] constructors = Cpu.class.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(LOGGER::info);
        Field[] fields = Cpu.class.getDeclaredFields();
        Arrays.stream(fields).forEach(LOGGER::info);
        Method[] methods = Cpu.class.getDeclaredMethods();
        Arrays.stream(methods).forEach(LOGGER::info);
        Cpu cpu = new Cpu();
        String manufacture = cpu.getManufacture();
        double frequency = 0;
        LOGGER.info(frequency);
        try {
            Field field = cpu.getClass().getDeclaredField("frequency");
            field.setAccessible(true);
            frequency = (double) field.get(cpu);
            LOGGER.info(frequency);
            cpu = (Cpu) constructors[1].newInstance("AMD", 2.7);
            LOGGER.info(cpu);
            Method method = cpu.getClass().getDeclaredMethod("get" + StringUtils.capitalize(fields[1].getName()));
            field.set(cpu, 4.1);
            frequency = (double) method.invoke(cpu);
            LOGGER.info(cpu);
        } catch (NoSuchFieldException e) {
            LOGGER.info(e);
        } catch (IllegalAccessException ex) {
            LOGGER.info(ex);
        } catch (InstantiationException exc) {
            LOGGER.info(exc);
        } catch (InvocationTargetException exce) {
            LOGGER.info(exce);
        } catch (NoSuchMethodException excep) {
            LOGGER.info(excep);
        }


    }

    private void runThreads() {

        Thread firstThread = new Thread(() -> {
            LOGGER.info(Thread.currentThread().getName() + " start");
            synchronized (firstClient) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    LOGGER.info(e);
                }
                synchronized (secondClient) {
                }
            }
            LOGGER.info(Thread.currentThread().getName() + " end");
        }, "FirstThread");

        Thread secondThread = new Thread(() -> {
            LOGGER.info(Thread.currentThread().getName() + " start");
            synchronized (secondClient) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    LOGGER.info(e);
                }
                synchronized (firstClient) {
                }
            }
            LOGGER.info(Thread.currentThread().getName() + " end");
        }, "SecondThread");
        firstThread.start();
        secondThread.start();

    }

    private void connectDB() {
        IBatteryDAO b = new BatteryDAO();
        try {
            LOGGER.info(b.getEntityById(3));
            LOGGER.info(b.getEntityById(5));
            b.getAllBatteries();
            b.createEntity(new mobilestore.classes.Battery("Xiaomi", 3550, 33));
            b.createEntity(new mobilestore.classes.Battery("Xiaomi", 4150, 41));
            b.createEntity(new mobilestore.classes.Battery("Xiaomi", 4200, 47));
            b.removeEntity(13);
            b.updateEntity(batteryBD);
        } catch (SQLException e) {
            LOGGER.info(e);
        }
    }


    public static void main(String[] args) {

        Main main = new Main();
//        main.runPreviousLesson();
//        main.runThirdLesson();
//        main.runFourthLesson();
//        main.runFifthLesson();
//        main.useCollectionLesson();
//        main.useUtilsLesson();
//        main.useLambdaAndEnumLesson();
//        main.useReflection();
//        main.runThreads();
        main.connectDB();
    }
}
