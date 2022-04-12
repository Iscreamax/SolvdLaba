package iphone;

import exception.DiscountException;
import exception.PriceException;
import exception.WarehouseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class SaleShop implements Comparable<SaleShop> {
    private int discountPrice;
    private int percent;
    private MobilePhone mobilePhone;
    private String imei;
    private static final Logger LOGGER = LogManager.getLogger(SaleShop.class);

    public SaleShop() {

    }

    public SaleShop(int percent) throws DiscountException {
        setPercent(percent);
    }

    public SaleShop(int percent, MobilePhone mobilePhone, Map warehouse) throws WarehouseException, DiscountException {
        if (warehouse.get(mobilePhone.getImei()) == mobilePhone) {
            setPercent(percent);
            this.percent = percent;
            this.discountPrice = countDiscountPrice(mobilePhone, percent);
            this.imei = mobilePhone.getImei();
            warehouse.remove(mobilePhone.getImei());
            mobilePhone.setPrice(discountPrice);
            this.mobilePhone = mobilePhone;
        } else {
            throw new WarehouseException();
        }
    }

    public MobilePhone getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public void setPercent(int percent) throws DiscountException {
        switch (percent) {
            case (10):
                percent = 10;
                break;
            case (20):
                percent = 20;
                break;
            case (30):
                percent = 30;
                break;
            case (40):
                percent = 40;
                break;
            default:
                throw new DiscountException();
        }

    }

    public int getPercent() {
        return percent;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }


    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    //Counting the discountPrice
    public int countDiscountPrice(MobilePhone mobilePhone, int percent) {
        discountPrice = (int) (mobilePhone.getPrice() * (1 - (percent / 100d)));
        return discountPrice;
    }

    //Handle exception with try-catch and signature
    public void countDiscount(MobilePhone mobilePhone, String percent) throws PriceException {
        try {
            int discount = Integer.parseInt(percent) / 100;
            mobilePhone.getDiscount();
            discountPrice = mobilePhone.getPrice() * (1 - discount);
        } catch (NumberFormatException e) {
            try {
                throw new PriceException("String is incorrect!", e);

            } catch (PriceException ex) {
                LOGGER.info("The price is incorrect");
                LOGGER.debug(ex);
            }
            LOGGER.debug(e);
        }
    }

    @Override
    public String toString() {
        return "Sale Shop{" +
                "discountPrice=" + discountPrice +
                ", discount percentage=" + percent +
                ", mobilePhone=" + mobilePhone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleShop that = (SaleShop) o;
        if (that.imei != ((SaleShop) o).imei) return false;
        else return ((SaleShop) o).mobilePhone.equals(mobilePhone);
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(mobilePhone.getImei());
    }

    @Override
    public int compareTo(SaleShop o) {
        return this.percent - o.percent;
    }


}
