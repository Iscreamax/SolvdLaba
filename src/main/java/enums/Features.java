package enums;

public enum Features {
    SAMSUNG(MainFeatures.BRAND,SubFeatures.SAMSUNG),
    IPHONE(MainFeatures.BRAND,SubFeatures.IPHONE),
    XIAOMI(MainFeatures.BRAND,SubFeatures.XIAOMI),
    HUAWEI(MainFeatures.BRAND,SubFeatures.HUAWEI),
    LG(MainFeatures.BRAND,SubFeatures.LG),
    OLED(MainFeatures.DISPLAY,SubFeatures.OLED),
    IPS(MainFeatures.DISPLAY,SubFeatures.IPS),
    INCH(MainFeatures.DISPLAY,SubFeatures.INCH),
    FREQUENCY(MainFeatures.CPU,SubFeatures.FREQUENCY),
    MAH(MainFeatures.BATTERY,SubFeatures.MAH),
    GB(MainFeatures.MEMORY,SubFeatures.GB);

    private MainFeatures mainFeatures;
    private SubFeatures subFeatures;

    Features(MainFeatures mainFeatures, SubFeatures subFeatures) {
        this.mainFeatures = mainFeatures;
        this.subFeatures = subFeatures;
    }

    public MainFeatures getMainFeatures() {
        return mainFeatures;
    }

    public SubFeatures getSubFeatures() {
        return subFeatures;
    }

}
