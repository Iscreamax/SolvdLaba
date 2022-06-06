package mobilestore.pattern;




public enum DAO {
    BATTERY("BatteryDAO"),
    USER("UserDAO"),
    CLIENT("ClientDAO"),
    MEMORY("MemoryDAO"),
    MOBILE_STORE("MobileStoreDAO"),
    JDBC("jdbc"),
    MY_BATIS("MyBatis");


    private String value;

    DAO(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
