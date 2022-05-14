package mobilestore.dao.interfaces;

import mobilestore.classes.Memory;

public interface IMemoryDAO extends IBaseDAO<Memory> {
    void getAllBatteries ();
}
