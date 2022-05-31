package mobilestore.database.dao.interfaces;


import mobilestore.database.models.Memory;

public interface IMemoryDAO extends IBaseDAO<Memory> {
    void showAllMemories();
}
