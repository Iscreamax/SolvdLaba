package mobilestore.database.dao.interfaces;

import mobilestore.database.models.Order;

public interface IOrderDAO extends IBaseDAO<Order>{
    void showAllOrders ();
}
