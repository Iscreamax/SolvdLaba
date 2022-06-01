package mobilestore.database.dao.interfaces;


import mobilestore.database.models.Client;

import java.util.*;

public interface IClientDAO extends IBaseDAO<Client> {
    void showAllClients();

    List<Client> getClients();
}
