package mobilestore.dao.interfaces;

import mobilestore.classes.User;


public interface IUserDAO extends IBaseDAO<User> {
    void getAllUsers();
}
