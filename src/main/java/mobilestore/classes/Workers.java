package mobilestore.classes;

public class Workers {
    private long id;
    private String position;
    private String experience;
    private long userId;
    private long mobileStoreId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getMobileStoreId() {
        return mobileStoreId;
    }

    public void setMobileStoreId(long mobileStoreId) {
        this.mobileStoreId = mobileStoreId;
    }
}
