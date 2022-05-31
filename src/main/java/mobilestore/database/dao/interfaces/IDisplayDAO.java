package mobilestore.database.dao.interfaces;


import mobilestore.database.models.Display;

public interface IDisplayDAO extends IBaseDAO<Display> {
    void showAllDisplays ();
}
