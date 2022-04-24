package iphone;

import inerfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class MobilePhone extends Phone implements IInstallingApplication, IUpdate, IMakePhoto, IMakeVideo, ISendMessage {
    private static final Logger LOGGER = LogManager.getLogger(MobilePhone.class);
    private Battery battery;
    private Memory memory;
    private Display display;
    private Cpu cpu;
    private final String imei;
    private static int createdMobile = 0;

    protected MobilePhone(int model, String version) {
        super(model, version);
        imei = createImei();
        createdMobile++;
    }

    protected MobilePhone(int model, String version, Memory memory, Battery battery, Display display, Cpu cpu, int price) {
        super(model, version, price);
        this.memory = memory;
        this.battery = battery;
        this.display = display;
        this.cpu = cpu;
        imei = createImei();
        createdMobile++;

    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public String getImei() {
        return imei;
    }

    public static int getCreatedMobile() {
        return createdMobile;
    }

    public String createImei() {
        String result = "";
        for (int i = 0; i < 15; i++) {
            String j;
            j = Integer.toString((int) (Math.random() * 10));
            result = result + j;
        }
        return result;
    }

    @Override
    public void makeCall(Client firstClient, Client secondClient) {
        LOGGER.info(firstClient.getFirstName() + " called " + secondClient.getFirstName() + " by 5G.");
    }

    public void satelliteConnection() {
        LOGGER.info("The connection with the satellite is established!");
    }

    public abstract void turnOnMobile();

    public abstract void registration(Client client);

    public abstract void internetConnection();

    @Override
    public void sendMessage(Message message, Client firstClient, Client secondClient) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MobilePhone that = (MobilePhone) o;
        if (that.imei != ((MobilePhone) o).imei) return false;
        return Objects.equals(battery, that.battery) && Objects.equals(memory, that.memory) && Objects.equals(display, that.display) && Objects.equals(cpu, that.cpu) && Objects.equals(imei, that.imei);
    }


    @Override
    public int hashCode() {
        return Objects.hash(battery, memory, display, cpu, imei);
    }

    public static void created() {
        LOGGER.info("\n" + "Number of phones created today: " + createdMobile);
    }
}
