package mobilestore.dao;

import mobilestore.classes.Client;



public interface IClientDAO extends IBaseDAO<Client> {
    void getAllBatteries ();
}
