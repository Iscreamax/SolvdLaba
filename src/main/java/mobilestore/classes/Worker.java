package mobilestore.classes;

public class Worker {
    private int id;
    private String position;
    private String experience;
    private int userId;
    private int mobileStoreId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMobileStoreId() {
        return mobileStoreId;
    }

    public void setMobileStoreId(int mobileStoreId) {
        this.mobileStoreId = mobileStoreId;
    }
}
