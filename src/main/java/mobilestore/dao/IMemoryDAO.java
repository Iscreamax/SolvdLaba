package mobilestore.dao;

import mobilestore.classes.Memory;

public interface IMemoryDAO extends IBaseDAO<Memory> {
    void getAllBatteries ();
}
