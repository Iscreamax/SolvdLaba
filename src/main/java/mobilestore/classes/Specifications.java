package mobilestore.classes;

import java.util.List;

public class Specifications {
    private long id;
    private List<Processors> cpuId;
    private List<Displays> displayId;
    private List<Batteries>batteryId;
    private List<Memories>memoryId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Processors> getCpuId() {
        return cpuId;
    }

    public void setCpuId(List<Processors> cpuId) {
        this.cpuId = cpuId;
    }

    public List<Displays> getDisplayId() {
        return displayId;
    }

    public void setDisplayId(List<Displays> displayId) {
        this.displayId = displayId;
    }

    public List<Batteries> getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(List<Batteries> batteryId) {
        this.batteryId = batteryId;
    }

    public List<Memories> getMemoryId() {
        return memoryId;
    }

    public void setMemoryId(List<Memories> memoryId) {
        this.memoryId = memoryId;
    }
}
