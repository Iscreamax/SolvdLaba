package mobilestore.classes;

import java.util.List;

public class Specification {
    private int id;
    private List<Processor> cpuId;
    private List<Display> displayId;
    private List<Battery>batteryId;
    private List<Memory>memoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Processor> getCpuId() {
        return cpuId;
    }

    public void setCpuId(List<Processor> cpuId) {
        this.cpuId = cpuId;
    }

    public List<Display> getDisplayId() {
        return displayId;
    }

    public void setDisplayId(List<Display> displayId) {
        this.displayId = displayId;
    }

    public List<Battery> getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(List<Battery> batteryId) {
        this.batteryId = batteryId;
    }

    public List<Memory> getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(List<Memory> memoryId) {
        this.memoryId = memoryId;
    }
}
