package enums;

public enum SubFeatures {
    SAMSUNG("Samsung"), IPHONE("Iphone"), XIAOMI("Xiaomi"), HUAWEI("Huawei"), LG("LG"),
    OLED("Oled"), IPS("Ips"), INCH("Inch"), FREQUENCY("Frequency"), MAH("mAh"), GB("Gb");

    private String value;

    SubFeatures(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
