package iphone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Samsung extends MobilePhone {
    private static final Logger LOGGER = LogManager.getLogger(Samsung.class);

    public Samsung(int model, String version, Memory memory, Battery battery, Display display, Cpu cpu, int price) {
        super(model, version, memory, battery, display, cpu, price);

    }

    public String toString() {
        return ("Samsung " + getModel() + "/" + getVersion() + "/" + getMemory().getCapacity() + "Gb/"
                + getBattery().getCapacity() + "mah/" + getDisplay().getInch() + "inh/" + getCpu().getFrequency() +
                "Ggz/price -" + getPrice() + "$");
    }

    @Override
    public void turnOnMobile() {
        LOGGER.info("You've turned on your phone" + "\n" + "iphone.Samsung enabled");
    }

    @Override
    public void registration(Client client) {
        LOGGER.info("The user " + client.getFirstName() + " " + client.getSurname() + " is registered an account via iphone.Samsung");
    }

    @Override
    public void installingApplication() {
        LOGGER.info("Install application via Play Market");
    }

    @Override
    public void update() {
        LOGGER.info("Android updated");
    }

    @Override
    public void sendMessage(Message message, Client firstClient, Client secondClient) {
        LOGGER.info("Dear " + secondClient.getFirstName() + secondClient.getSurname() + secondClient.getPatronymic() + ", " +
                "It's " + firstClient.getFirstName() + firstClient.getSurname() + firstClient.getPatronymic() + ", " + message.getLetterField());
    }

    @Override
    public void makeVideo() {
        LOGGER.info("Shot a video in FullHD");
    }

    @Override
    public void makePhoto() {
        LOGGER.info("The photo was taken on a 15 Mp, 22mm camera");
    }

    @Override
    public void internetConnection() {
        LOGGER.info("5G works here");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Samsung that = (Samsung) obj;
        if (getModel() != that.getModel()) return false;
        if (getVersion() != that.getVersion()) return false;
        if (getDisplay() != that.getDisplay()) return false;
        if (getCpu() != that.getCpu()) return false;
        if (getBattery() != getBattery()) return false;
        return Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {
        int result = getModel() == 0 ? 0 : Objects.hashCode(getModel());
        result = 31 * result * getPrice();
        result = 31 * result * getBattery().hashCode();
        result = 31 * result * getCpu().hashCode();
        result = 31 * result * getDisplay().hashCode();
        result = 31 * result * getVersion().hashCode();
        result = 31 * result * getMemory().hashCode();
        return result;
    }
}
