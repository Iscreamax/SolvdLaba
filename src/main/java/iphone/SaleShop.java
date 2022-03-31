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

    public SaleShop(int percent, MobilePhone mobilePhone, Map warehouse) throws WarehouseException, DiscountException, PriceException {
        if (warehouse.get(mobilePhone.imei) == mobilePhone) {
            setPercent(percent);
            this.percent = percent;
            this.discountPrice = getDiscountPrice(mobilePhone, percent);
            this.imei = mobilePhone.imei;
            warehouse.remove(mobilePhone.imei);
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

    //Counting the discountPrice
    public int getDiscountPrice(MobilePhone mobilePhone, int percent) {
        discountPrice = (int) (mobilePhone.getPrice() * (1 - (double) (percent / 100d)));
        return discountPrice;
    }

    //Handle exception with try-catch and signature
    public void getDiscount(MobilePhone mobilePhone, String percent) throws PriceException {
        try {
            int discount = Integer.parseInt(percent) / 100;
            mobilePhone.getDiscount(0);
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
        return Integer.parseInt(mobilePhone.imei);
    }

    @Override
    public int compareTo(SaleShop o) {
        return this.percent - o.percent;
    }
}
