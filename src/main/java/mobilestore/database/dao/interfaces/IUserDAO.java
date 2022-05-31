package mobilestore.database.dao.interfaces;

import mobilestore.database.models.User;


public interface IUserDAO extends IBaseDAO<User> {
    void showAllUsers();
}
