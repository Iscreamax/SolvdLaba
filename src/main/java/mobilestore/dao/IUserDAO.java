package mobilestore.dao;

import mobilestore.classes.User;


public interface IUserDAO extends IBaseDAO<User> {
    void getAllBatteries();
}
