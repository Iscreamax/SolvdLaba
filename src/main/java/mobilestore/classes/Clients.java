package mobilestore.classes;

public class Clients {
    private long id;
    private String creditCardNumber;
    private long userId;
    private String validTHRU;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public long getUser_id() {
        return userId;
    }

    public void setUser_id(long user_id) {
        this.userId = userId;
    }

    public String getValidTHRU() {
        return validTHRU;
    }

    public void setValidTHRU(String validTHRU) {
        this.validTHRU = validTHRU;
    }
}
