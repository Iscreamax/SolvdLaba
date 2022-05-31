package mobilestore.database.dao.interfaces;


import mobilestore.database.models.Client;

public interface IClientDAO extends IBaseDAO<Client> {
    void showAllClients ();
}
