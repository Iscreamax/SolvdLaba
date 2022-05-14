package mobilestore.dao.interfaces;

import mobilestore.classes.Client;



public interface IClientDAO extends IBaseDAO<Client> {
    void getAllBatteries ();
}
