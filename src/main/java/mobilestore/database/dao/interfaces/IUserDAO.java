package mobilestore.database.dao.interfaces;

import mobilestore.database.models.User;

import java.util.*;


public interface IUserDAO extends IBaseDAO<User> {
    void showAllUsers();
    List<User> getUsers();
}
