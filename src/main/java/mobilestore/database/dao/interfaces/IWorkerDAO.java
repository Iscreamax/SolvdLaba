package mobilestore.database.dao.interfaces;


import mobilestore.database.models.Worker;

import java.util.List;

public interface IWorkerDAO extends IBaseDAO<Worker>{
    void showAllWorkers();
    List<Worker> getWorkers();
}
