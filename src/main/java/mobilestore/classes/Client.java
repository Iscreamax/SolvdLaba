package mobilestore.classes;

public class Client {
    private int id;
    private String creditCardNumber;
    private int userId;
    private String validTHRU;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = userId;
    }

    public String getValidTHRU() {
        return validTHRU;
    }

    public void setValidTHRU(String validTHRU) {
        this.validTHRU = validTHRU;
    }
}
