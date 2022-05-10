package mobilestore.classes;

import java.util.List;

public class Warranties {
    private long id;
    private List<Clients> clientsId;
    private String nameBreakdown;
    private long mobilePhoneId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Clients> getClientsId() {
        return clientsId;
    }

    public void setClientsId(List<Clients> clientsId) {
        this.clientsId = clientsId;
    }

    public String getNameBreakdown() {
        return nameBreakdown;
    }

    public void setNameBreakdown(String nameBreakdown) {
        this.nameBreakdown = nameBreakdown;
    }

    public long getMobilePhoneId() {
        return mobilePhoneId;
    }

    public void setMobilePhoneId(long mobilePhoneId) {
        this.mobilePhoneId = mobilePhoneId;
    }



}
