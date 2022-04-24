package iphone;

import exception.PriceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public abstract class Phone {

    private int model;
    private String version;
    private int price;
    private int discount;
    private static final Logger LOGGER = LogManager.getLogger(Phone.class);

    protected Phone(int price) {
        this.price = price;
    }

    protected Phone(int model, String version) {
        this.model = model;
        this.version = version;
    }

    protected Phone(int model, String version, int price) {
        this.model = model;
        this.version = version;
        this.price = price;
    }

    protected Phone(int model, String version, int price, int discount) {
        this.model = model;
        this.version = version;
        this.price = price;
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setPrice(int price) {
        if (price <= 0) {
            try {
                throw new PriceException("Price is incorrect!");
            } catch (PriceException e) {
                LOGGER.info("Price in incorrect");
            }
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return model == phone.model && price == phone.price && discount == phone.discount && Objects.equals(version, phone.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, version, price, discount);
    }

    public void alarmCall() {
        LOGGER.info("Hello this is 911");
    }


    public void makeCall(Client firstClient, Client secondClient) {

        LOGGER.info(firstClient.getFirstName() + " called " + secondClient.getFirstName() + " on the analog line.");
    }


}
